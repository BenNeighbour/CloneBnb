package com.benneighbour.CloneBnb.commonlibrary.command;

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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateListingCommand implements Serializable {

  private static final long serialVersionUID = 275181017556478313L;

  @TargetAggregateIdentifier public UUID listingId;

  public String name;

  public String description;

  public String longDescription;

  public String location;

  public String address;

  public PropertyType type;

  public Integer numberOfGuests;

  public String thumbnailUrl;

  public Integer averageStars;

  public List<Amenity> amenities;

  public List<LocalDate> unvacantDates;

  public Integer numberOfBedrooms;

  public Integer numberOfBeds;

  public Integer numberOfBathrooms;

  public UUID ownerId;

  public Double pricePerNight;

  protected CreateListingCommand(CreateListingCommand createListingCommand) {
    this.listingId = createListingCommand.getListingId();
    this.name = createListingCommand.getName();
    this.description = createListingCommand.getDescription();
    this.longDescription = createListingCommand.getLongDescription();
    this.location = createListingCommand.getLocation();
    this.address = createListingCommand.getAddress();
    this.type = createListingCommand.getType();
    this.numberOfGuests = createListingCommand.getNumberOfGuests();
    this.thumbnailUrl = createListingCommand.getThumbnailUrl();
    this.averageStars = createListingCommand.getAverageStars();
    this.amenities = createListingCommand.getAmenities();
    this.unvacantDates = createListingCommand.getUnvacantDates();
    this.numberOfBedrooms = createListingCommand.getNumberOfBedrooms();
    this.numberOfBeds = createListingCommand.getNumberOfBeds();
    this.numberOfBathrooms = createListingCommand.getNumberOfBathrooms();
    this.ownerId = createListingCommand.getOwnerId();
    this.pricePerNight = createListingCommand.getPricePerNight();
  }

  public enum PropertyType {
    Apartment("Apartment"),
    House("House");

    public String val;

    PropertyType(String val) {
      this.val = val;
    }

    public String getVal() {
      return val;
    }

    public void setVal(String val) {
      this.val = val;
    }
  }
}
