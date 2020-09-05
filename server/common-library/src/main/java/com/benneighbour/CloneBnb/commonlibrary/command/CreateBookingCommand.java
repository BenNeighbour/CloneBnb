package com.benneighbour.CloneBnb.commonlibrary.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

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
@AllArgsConstructor
public class CreateBookingCommand implements Serializable {

  private static final long serialVersionUID = -809533164414758653L;

  @TargetAggregateIdentifier private UUID bookingId;

  private UUID listingId;

  private UUID userId;

  private LocalDate checkInDate;

  private LocalDate checkOutDate;

  private BigDecimal price;

  protected CreateBookingCommand(CreateBookingCommand createBookingCommand) {
    this.bookingId = createBookingCommand.getBookingId();
    this.listingId = createBookingCommand.getListingId();
    this.userId = createBookingCommand.getUserId();
    this.checkInDate = createBookingCommand.getCheckInDate();
    this.checkOutDate = createBookingCommand.getCheckOutDate();
    this.price = createBookingCommand.price;
  }
}
