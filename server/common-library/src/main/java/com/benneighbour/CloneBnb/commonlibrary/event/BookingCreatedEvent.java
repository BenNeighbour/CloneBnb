package com.benneighbour.CloneBnb.commonlibrary.event;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateBookingCommand;

import java.io.Serializable;

/**
 * @author Ben Neighbour
 * @created 05/09/2020
 * @project CloneBnb
 */
public class BookingCreatedEvent extends CreateBookingCommand implements Serializable {

  private static final long serialVersionUID = -3626805479948307539L;

  public BookingCreatedEvent(CreateBookingCommand createBookingCommand) {
    super(createBookingCommand);
  }
}
