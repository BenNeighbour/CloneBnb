package com.benneighbour.CloneBnb.sagaeventservice.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
public class Listing implements Serializable {

  private static final long serialVersionUID = 8096657782794609195L;

  public UUID id;

  public String name;

  public String description;

  public String longDescription;

  public String location;

  public String address;

  public List<Amenity> amenities;

  public PropertyType type;

  public Integer numberOfGuests;

  public String thumbnailUrl;

  public Integer averageStars;

  public List<LocalDate> unvacantDates;

  public Integer numberOfBedrooms;

  public Integer numberOfBeds;

  public Integer numberOfBathrooms;

  public User owner;

  public Double pricePerNight;

  public Listing() {}

  protected Listing(Listing listing) {
    this.id = listing.id;
    this.name = listing.name;
    this.description = listing.description;
    this.longDescription = listing.longDescription;
    this.location = listing.location;
    this.address = listing.address;
    this.amenities = listing.amenities;
    this.type = listing.type;
    this.numberOfGuests = listing.numberOfGuests;
    this.thumbnailUrl = listing.thumbnailUrl;
    this.averageStars = listing.averageStars;
    this.unvacantDates = listing.unvacantDates;
    this.numberOfBedrooms = listing.numberOfBedrooms;
    this.numberOfBeds = listing.numberOfBeds;
    this.numberOfBathrooms = listing.numberOfBathrooms;
    this.owner = listing.owner;
    this.pricePerNight = listing.pricePerNight;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String city) {
    this.location = location;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Amenity> getAmenities() {
    return amenities;
  }

  public void setAmenities(List<Amenity> amenities) {
    this.amenities = amenities;
  }

  public PropertyType getType() {
    return type;
  }

  public void setType(PropertyType type) {
    this.type = type;
  }

  public Integer getNumberOfGuests() {
    return numberOfGuests;
  }

  public void setNumberOfGuests(Integer numberOfGuests) {
    this.numberOfGuests = numberOfGuests;
  }

  public Integer getAverageStars() {
    return averageStars;
  }

  public void setAverageStars(Integer averageStars) {
    this.averageStars = averageStars;
  }

  public List<LocalDate> getUnvacantDates() {
    return unvacantDates;
  }

  public void setUnvacantDates(List<LocalDate> unvacantDates) {
    this.unvacantDates = unvacantDates;
  }

  public Integer getNumberOfBedrooms() {
    return numberOfBedrooms;
  }

  public void setNumberOfBedrooms(Integer numberOfBedrooms) {
    this.numberOfBedrooms = numberOfBedrooms;
  }

  public Integer getNumberOfBeds() {
    return numberOfBeds;
  }

  public void setNumberOfBeds(Integer numberOfBeds) {
    this.numberOfBeds = numberOfBeds;
  }

  public Integer getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  public void setNumberOfBathrooms(Integer numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(Double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  enum PropertyType {
    Apartment,
    House
  }
}
