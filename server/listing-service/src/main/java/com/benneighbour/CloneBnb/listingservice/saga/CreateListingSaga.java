package com.benneighbour.CloneBnb.listingservice.saga;

import com.benneighbour.CloneBnb.commonlibrary.event.ListingCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;

/**
 * @author Ben Neighbour
 * @created 04/09/2020
 * @project CloneBnb
 */
@Saga
public class CreateListingSaga {

  @Inject private transient CommandGateway gateway;

  @StartSaga
  @SagaEventHandler(associationProperty = "listingId")
  public void handle(ListingCreatedEvent event) {
    SagaLifecycle.associateWith("listingId", event.getListingId().toString());
    System.out.println("Create listing saga started!");

    System.out.println("Create listing saga ended!");
    SagaLifecycle.end();
  }
}
