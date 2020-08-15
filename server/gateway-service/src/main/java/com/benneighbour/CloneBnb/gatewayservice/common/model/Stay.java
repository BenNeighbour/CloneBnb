package com.benneighbour.CloneBnb.gatewayservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
public class Stay extends Listing implements Serializable {

  private static final long serialVersionUID = -6630351652984697943L;

  private LocalDate checkInDate;

  private LocalDate checkOutDate;

  private Boolean isFinished = false;

  private UUID userId;

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

  public Boolean getFinished() {
    return isFinished;
  }

  public void setFinished(Boolean finished) {
    isFinished = finished;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }
}
