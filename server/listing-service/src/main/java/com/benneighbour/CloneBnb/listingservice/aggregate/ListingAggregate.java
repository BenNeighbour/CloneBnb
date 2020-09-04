package com.benneighbour.CloneBnb.listingservice.aggregate;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.commonlibrary.event.ListingCreatedEvent;
import com.benneighbour.CloneBnb.commonlibrary.model.Amenity;
import com.benneighbour.CloneBnb.commonlibrary.model.ListingStatus;
import com.benneighbour.CloneBnb.listingservice.common.GlobalDao;
import com.benneighbour.CloneBnb.listingservice.common.User;
import com.benneighbour.CloneBnb.listingservice.service.ListingService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 04/09/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@Aggregate
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ListingAggregate implements Serializable {

  public static final long serialVersionUID = -4257959258016428519L;

  @AggregateIdentifier(routingKey = "listingId")
  public UUID listingId;

  public String name;

  public String description;

  public String longDescription;

  public String location;

  public String address;

  public List<Amenity> amenities;

  public CreateListingCommand.PropertyType type;

  public Integer numberOfGuests;

  public String thumbnailUrl;

  public Integer averageStars;

  public List<LocalDate> unvacantDates;

  public Integer numberOfBedrooms;

  public Integer numberOfBeds;

  public Integer numberOfBathrooms;

  public UUID ownerId;

  public Double pricePerNight;

  public ListingStatus status;

  @EventSourcingHandler
  public void handle(ListingCreatedEvent event) {
    try {
      BeanUtils.copyProperties(this, event);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @CommandHandler
  public ListingAggregate(CreateListingCommand command, @Autowired ListingService service) {
    // Actually create the listing before issuing a created event
    try {
      service.saveListingFromCommand(command);
    } catch (Exception e) {
      e.printStackTrace();
    }

    ListingCreatedEvent event = new ListingCreatedEvent(command);
    event.setListingId(UUID.randomUUID());
    AggregateLifecycle.apply(event);
  }
}
