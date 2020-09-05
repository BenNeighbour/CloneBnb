package com.benneighbour.CloneBnb.bookingservice.saga;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateStayCommand;
import com.benneighbour.CloneBnb.commonlibrary.event.BookingCreatedEvent;
import com.benneighbour.CloneBnb.commonlibrary.event.StayCreatedEvent;
import org.apache.commons.beanutils.BeanUtils;
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

  @Inject private transient CommandGateway gateway;

  @StartSaga
  @SagaEventHandler(associationProperty = "bookingId")
  public void handle(BookingCreatedEvent event) throws Exception {
    SagaLifecycle.associateWith("bookingId", event.getListingId().toString());
    System.out.println("Book booking saga started!");

    try {
      CreateStayCommand createStay = new CreateStayCommand();

      // Create the stay between the dates of the booking
      BeanUtils.copyProperties(createStay, event);

      // Issue that create stay command
      gateway.send(createStay);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @SagaEventHandler(associationProperty = "stayId")
  public void handle(StayCreatedEvent event) {
    SagaLifecycle.associateWith("stayId", event.getStayId().toString());

    System.out.println("Book booking saga ended!");
    SagaLifecycle.end();
  }
}
