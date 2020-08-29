package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.sagaeventservice.events.ListingCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
@Saga
public class ListingManagementSaga {

  @Inject private transient CommandGateway gateway;

  @StartSaga
  @SagaEventHandler(associationProperty = "listingId")
  public void handle(ListingCreatedEvent event) {
    System.out.println("Listing Saga Invoked");
    System.out.println("Listing Id: " + event.listingId);
  }

  //.......
}
