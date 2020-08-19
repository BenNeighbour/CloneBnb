package com.benneighbour.CloneBnb.gatewayservice.common.model;

import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  private String name;

  private String city;

  private String address;

  private List<Amenity> amenities;

  private PropertyType type;

  private Integer numberOfGuests;

  // TODO: List of pictures here

  private Integer averageStars;

  private List<LocalDate> unvacantDates;

  private Integer numberOfBedrooms;

  private Integer numberOfBeds;

  private Integer numberOfBathrooms;

  private User owner;

  private Double pricePerNight;


  public Listing() {}

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

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
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

  enum PropertyType {
    Apartment,
    House
  }
}
