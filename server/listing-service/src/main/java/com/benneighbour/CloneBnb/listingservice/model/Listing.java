package com.benneighbour.CloneBnb.listingservice.model;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.listingservice.common.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
@Entity
@Table(name = "listing")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Listing implements Serializable {

  private static final long serialVersionUID = -2907044854812972105L;

  @Id
  @GeneratedValue
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(columnDefinition = "uuid", updatable = false, name = "id")
  private UUID listingId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "longDescription", nullable = false)
  private String longDescription;

  @Column(name = "location", nullable = false)
  private String location;

  @Column(name = "address", nullable = false)
  private String address;

  @ElementCollection(fetch = FetchType.LAZY)
  @JoinTable(name = "amenity", joinColumns = @JoinColumn(name = "listing_id"))
  @Enumerated(EnumType.ORDINAL)
  private List<Amenity> amenities;

  @Column(name = "type", nullable = false)
  private CreateListingCommand.PropertyType type;

  @Column(name = "numberOfGuests", nullable = false)
  private Integer numberOfGuests;

  @Column(name = "thumbnail", nullable = false)
  private String thumbnailUrl;

  @Transient private Integer averageStars;

  @Transient private List<LocalDate> unvacantDates;

  @Column(name = "numberOfBedrooms", nullable = false)
  private Integer numberOfBedrooms;

  @Column(name = "numberOfBeds", nullable = false)
  private Integer numberOfBeds;

  @Column(name = "numberOfBathrooms", nullable = false)
  private Integer numberOfBathrooms;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Transient private User owner;

  @Column(name = "ownerId", nullable = false)
  private UUID ownerId;

  @Column(name = "pricePerNight", nullable = false)
  private Double pricePerNight;

  @Transient
  private List<Review> reviews;

  public Listing() {}

  public UUID getListingId() {
    return listingId;
  }

  public void setListingId(UUID listingId) {
    this.listingId = listingId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
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

  public CreateListingCommand.PropertyType getType() {
    return type;
  }

  public void setType(CreateListingCommand.PropertyType type) {
    this.type = type;
  }

  public Integer getNumberOfGuests() {
    return numberOfGuests;
  }

  public void setNumberOfGuests(Integer numberOfGuests) {
    this.numberOfGuests = numberOfGuests;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
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

  public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  public Double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(Double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
