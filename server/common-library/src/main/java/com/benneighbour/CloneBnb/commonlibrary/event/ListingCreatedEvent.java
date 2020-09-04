package com.benneighbour.CloneBnb.commonlibrary.event;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.commonlibrary.model.Amenity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 04/09/2020
 * @project CloneBnb
 */
public class ListingCreatedEvent extends CreateListingCommand implements Serializable {

  private static final long serialVersionUID = 6331409391038121690L;

  public ListingCreatedEvent(CreateListingCommand createListingCommand) {
    super(createListingCommand);
//    this.listingId = UUID.randomUUID();
  }
}
