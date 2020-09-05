package com.benneighbour.CloneBnb.listingservice.aggregate;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateStayCommand;
import com.benneighbour.CloneBnb.commonlibrary.event.StayCreatedEvent;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import com.benneighbour.CloneBnb.listingservice.service.ListingService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
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
public class StayAggregate implements Serializable {

  private static final long serialVersionUID = -5624776288896373906L;

  @AggregateIdentifier(routingKey = "stayId")
  private UUID stayId;

  private LocalDate checkInDate;

  private LocalDate checkOutDate;

  private boolean finished = false;

  private UUID userId;

  private Listing listing;

  @EventSourcingHandler
  public void handle(StayCreatedEvent event) {
    try {
      BeanUtils.copyProperties(this, event);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @CommandHandler
  public StayAggregate(CreateStayCommand command, @Autowired ListingService service) {
    // Actually create the listing before issuing a created event
    try {
      Stay stay = new Stay();

      BeanUtils.copyProperties(stay, command);
      service.createStay(stay);
    } catch (Exception e) {
      e.printStackTrace();
    }

    StayCreatedEvent event = new StayCreatedEvent(command);
    event.setListingId(UUID.randomUUID());
    AggregateLifecycle.apply(event);
  }
}
