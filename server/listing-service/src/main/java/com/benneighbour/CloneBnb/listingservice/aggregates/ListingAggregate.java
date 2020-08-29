package com.benneighbour.CloneBnb.listingservice.aggregates;

import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.sagaeventservice.commands.CreateListingCommand;
import com.benneighbour.CloneBnb.sagaeventservice.events.ListingCreatedEvent;
import com.benneighbour.CloneBnb.sagaeventservice.status.ListingStatus;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
@Aggregate
public class ListingAggregate {

  @TargetAggregateIdentifier private UUID listingId;

  private ListingStatus listingStatus;

  public ListingAggregate() {}

  @CommandHandler
  public ListingAggregate(CreateListingCommand command) {
    Listing listing = Listing.class.cast(command);

    ListingCreatedEvent event =
        new ListingCreatedEvent(
            com.benneighbour.CloneBnb.sagaeventservice.common.Listing.class.cast(listing),
            listingId,
            ListingStatus.CREATED);

    System.out.println("Listing Created Command Fired!");
    AggregateLifecycle.apply(event);
  }

  @EventSourcingHandler
  protected void on(ListingCreatedEvent listingCreatedEvent) {
    System.out.println("Listing has been Created SUCCESSFULLY!");
    this.listingId = listingCreatedEvent.listingId;
    this.listingStatus = ListingStatus.CREATED;
  }
}
