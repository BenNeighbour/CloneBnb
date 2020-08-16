package com.benneighbour.CloneBnb.listingservice.model;

import com.benneighbour.CloneBnb.listingservice.common.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Listing implements Serializable {

  private static final long serialVersionUID = -2907044854812972105L;

  @Id
  @GeneratedValue
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(columnDefinition = "uuid", updatable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "city")
  private String city;

  @Column(name = "address")
  private String address;

  @ElementCollection(fetch = FetchType.LAZY)
  @JoinTable(name = "amenity", joinColumns = @JoinColumn(name = "listing_id"))
  @Column(name = "amenity", nullable = false)
  @Enumerated(EnumType.STRING)
  private List<Amenity> amenities;

//  @OneToMany(cascade = CascadeType.ALL, targetEntity = Stay.class, fetch = FetchType.LAZY)
//  private List<Stay> stays;

  @Column(name = "type")
  private PropertyType type;

  @Column(name = "numberOfGuests")
  private Integer numberOfGuests;

  // TODO: List of pictures here

  @Transient private Integer averageStars;

  @Transient private List<LocalDate> vacantDates;

  @Column(name = "numberOfBedrooms")
  private Integer numberOfBedrooms;

  @Column(name = "numberOfBeds")
  private Integer numberOfBeds;

  @Column(name = "numberOfBathrooms")
  private Integer numberOfBathrooms;

  @Transient private User owner;

  @JsonIgnore
  @Column(name = "ownerId")
  private UUID ownerId;

  @Column(name = "pricePerNight")
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

  public List<LocalDate> getVacantDates() {
    return vacantDates;
  }

  public void setVacantDates(List<LocalDate> vacantDates) {
    this.vacantDates = vacantDates;
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

  public UUID getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
  }

  enum PropertyType {
    Apartment,
    House
  }
}
