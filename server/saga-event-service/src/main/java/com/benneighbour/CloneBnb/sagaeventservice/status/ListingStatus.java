package com.benneighbour.CloneBnb.sagaeventservice.status;

import java.util.stream.Stream;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
public enum ListingStatus {
  CREATED("CREATED"),
  UPDATED("UPDATED"),
  DELETED("DELETED");

  private String value;

  ListingStatus(String value) {
    this.value = value;
  }

  public static ListingStatus of(String value) {
    return Stream.of(ListingStatus.values())
        .filter(amenity -> amenity.getValue() == value)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
