package com.benneighbour.CloneBnb.commonlibrary.event;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;

import java.io.Serializable;

/**
 * @author Ben Neighbour
 * @created 04/09/2020
 * @project CloneBnb
 */
public class ListingCreatedEvent extends CreateListingCommand implements Serializable {

  private static final long serialVersionUID = 6331409391038121690L;

  public ListingCreatedEvent(CreateListingCommand createListingCommand) {
    super(createListingCommand);
  }
}
