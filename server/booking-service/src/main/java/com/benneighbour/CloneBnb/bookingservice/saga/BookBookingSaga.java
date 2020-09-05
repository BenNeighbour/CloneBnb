package com.benneighbour.CloneBnb.bookingservice.saga;

import com.benneighbour.CloneBnb.commonlibrary.event.BookingCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;

/**
 * @author Ben Neighbour
 * @created 05/09/2020
 * @project CloneBnb
 */
@Saga
public class BookBookingSaga {

    @Inject
    private transient CommandGateway gateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "bookingId")
    public void handle(BookingCreatedEvent event) {
        SagaLifecycle.associateWith("bookingId", event.getListingId().toString());
        System.out.println("Book booking saga started!");

        System.out.println("Book booking saga ended!");
        SagaLifecycle.end();
    }

}
