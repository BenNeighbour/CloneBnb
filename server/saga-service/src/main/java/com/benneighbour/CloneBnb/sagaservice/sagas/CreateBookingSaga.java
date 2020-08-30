package com.benneighbour.CloneBnb.sagaservice.sagas;

import com.benneighbour.CloneBnb.commonlibrary.Command;
import com.benneighbour.CloneBnb.commonlibrary.Message;
import com.benneighbour.CloneBnb.commonlibrary.SagaProvider;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Component
public class CreateBookingSaga {

  @Autowired private SagaProvider provider;

  @RabbitListener(queues = "Q1")
  public Message buyTicketSaga(Message message) {

    // If the RabbitMQ is not wanting to execute this specific task first, then do not do it!
    if (message.getCommand() != Command.BOOK_STAY) return message;

    // Initialize the rest of the steps for this saga
    Stack<Message> steps = new Stack<>();
    List<Message> nextSteps = new ArrayList<>();

    nextSteps.add(
        new Message(message.getContent(), Command.UPDATE_LISTING_FOR_BOOK, "listing-route"));

    nextSteps.forEach(steps::push);

    provider.trackSaga(steps, message);

    return message;
  }
}
