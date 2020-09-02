package com.benneighbour.CloneBnb.listingservice.broker;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ben Neighbour
 * @created 02/09/2020
 * @project CloneBnb
 */
@Component
public class MessagePublisher {

  @RabbitListener(queues = "listing.queue")
  public void printMessage(String message) {
    System.out.println(message);
  }


}
