package com.benneighbour.CloneBnb.bookingservice.aggregate;

import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import com.benneighbour.CloneBnb.bookingservice.service.BookingService;
import com.benneighbour.CloneBnb.commonlibrary.command.CreateBookingCommand;
import com.benneighbour.CloneBnb.commonlibrary.event.BookingCreatedEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 05/09/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@Aggregate
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookingAggregate implements Serializable {

  private static final long serialVersionUID = -6941155413163906644L;

  private UUID bookingId;

  private UUID listingId;

  private UUID userId;

  private LocalDate checkInDate;

  private LocalDate checkOutDate;

  private BigDecimal price;

  @EventSourcingHandler
  public void handle(BookingCreatedEvent event) {
    try {
      BeanUtils.copyProperties(this, event);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @CommandHandler
  public BookingAggregate(CreateBookingCommand command, @Autowired BookingService service) {
    Booking booking = new Booking();

    try {
      BeanUtils.copyProperties(booking, command);
      service.makeBooking(booking);
    } catch (Exception e) {
      e.printStackTrace();
    }

    BookingCreatedEvent event = new BookingCreatedEvent(command);
    event.setBookingId(UUID.randomUUID());
    AggregateLifecycle.apply(event);
  }
}
