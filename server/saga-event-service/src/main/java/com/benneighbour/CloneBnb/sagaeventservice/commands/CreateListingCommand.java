package com.benneighbour.CloneBnb.sagaeventservice.commands;

import com.benneighbour.CloneBnb.sagaeventservice.common.Listing;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
public class CreateListingCommand extends Listing {

  @TargetAggregateIdentifier public UUID listingId;

  public CreateListingCommand(Listing listing, UUID listingId) {
      super(listing);
      this.listingId = listingId;
  }
}
