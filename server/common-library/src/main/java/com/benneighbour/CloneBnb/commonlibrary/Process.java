package com.benneighbour.CloneBnb.commonlibrary;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Stack;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Getter
@Setter
public class Process implements ListenableFutureCallback<Message> {

  private boolean success;

  private Message output;

  private Stack<Message> completedSteps;

  public Process(Stack<Message> completedSteps) {
    this.completedSteps = completedSteps;
    this.success = true;
    this.output = null;
  }

  @Override
  public void onFailure(Throwable throwable) {
    this.success = false;
  }

  @Override
  public void onSuccess(Message message) {
    this.output = message;

    if (message.isFinished()) this.completedSteps.push(message);
    else this.success = false;
  }
}
