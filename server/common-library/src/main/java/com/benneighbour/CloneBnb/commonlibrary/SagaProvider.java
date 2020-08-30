package com.benneighbour.CloneBnb.commonlibrary;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Component
public class SagaProvider {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private AsyncRabbitTemplate asyncRabbitTemplate;

  @Autowired
  private DirectExchange exchange;

  @Autowired
  private SagaProvider provider;

  public SagaProvider() {}

  @Scheduled(fixedDelay = 1000, initialDelay = 500)
  public Message sendSync(Message message) {
    return (Message)
        rabbitTemplate.convertSendAndReceive(exchange.getName(), message.getRoute(), message);
  }

  @Scheduled(fixedDelay = 1000L)
  public AsyncRabbitTemplate.RabbitConverterFuture<Message> sendAsyncMessageFuture(
      Message message) {
    return asyncRabbitTemplate.convertSendAndReceive(
        exchange.getName(), message.getRoute(), message);
  }

  public void trackSaga(Stack<Message> steps, Message currentMessage) {
    // The status of the current saga that's running
    boolean hasFailed = false;

    Stack<Message> completedSteps = new Stack<>();
    int totalNumberOfSteps = steps.size();

    List<Process> processes = new ArrayList<>();

    // Start the bulk transaction on it's thread
    while (completedSteps.size() != totalNumberOfSteps) {
      if (steps.isEmpty()) {
        if (processes.size() > 0) {

          Iterator<Process> processIterator = processes.iterator();
          while (processIterator.hasNext()) {
            Process process = processIterator.next();

            if (process.getOutput() != null || !process.isSuccess()) {
              hasFailed = true;
              processIterator.remove();
            }
          }
        }

        // All of the processes are now complete
        if (hasFailed) {
          // Roll back each one of the previously completed steps
          while (!completedSteps.isEmpty()) {

            // Get the last step and roll-back
            Message rollbackStep = completedSteps.pop();
            rollbackStep.setRollbackCommand(rollbackStep.getCommand());
            provider.sendAsyncMessageFuture(rollbackStep);
          }
        }
      } else {
        // Carry on issuing commands to all of the other services

        // Go in linear order - over the rest of the stack
        Message currentStep = steps.pop();
        if (currentStep.isAsync()) {
          // If things are okay, create a new process for that requested task
          Process process = new Process(completedSteps);
          processes.add(process);

          provider.sendAsyncMessageFuture(currentStep).addCallback(process);
        } else {
          Message result = provider.sendSync(currentMessage);

          if (result.isFinished()) completedSteps.push(result);
          else {
            hasFailed = true;
            break;
          }
        }
      }
    }

    if (hasFailed) {
      while (!completedSteps.isEmpty()) {
        Message rollbackTask = completedSteps.pop();
        rollbackTask.setRollbackCommand(rollbackTask.getCommand());
        provider.sendAsyncMessageFuture(rollbackTask);
      }
    }
    if (!hasFailed) currentMessage.setFinished(true);
  }
}
