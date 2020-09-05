package com.benneighbour.CloneBnb.listingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
@Entity
@Table(name = "Stay")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class Stay implements Serializable {

  private static final long serialVersionUID = 6245537566711698920L;

  @Id
  @GeneratedValue
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(columnDefinition = "uuid", updatable = false, name = "id")
  private UUID stayId;

  @Column(name = "checkInDate")
  private LocalDate checkInDate;

  @Column(name = "checkOutDate")
  private LocalDate checkOutDate;

  @JsonProperty
  @Column(name = "finished")
  private boolean finished = false;

  @Column(name = "userId")
  private UUID userId;

  @ManyToOne(cascade = CascadeType.ALL, targetEntity = Listing.class, fetch = FetchType.LAZY)
  private Listing listing;

  public Stay() {}

  public LocalDate getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(LocalDate checkInDate) {
    this.checkInDate = checkInDate;
  }

  public LocalDate getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(LocalDate checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public UUID getStayId() {
    return stayId;
  }

  public void setStayId(UUID stayId) {
    this.stayId = stayId;
  }

  public Listing getListing() {
    return listing;
  }

  public void setListing(Listing listing) {
    this.listing = listing;
  }

  public boolean isFinished() {
    return finished;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }
}
