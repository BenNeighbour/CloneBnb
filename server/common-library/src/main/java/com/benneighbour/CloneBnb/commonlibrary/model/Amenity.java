package com.benneighbour.CloneBnb.commonlibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
public enum Amenity {
  Kitchen("Kitchen"),
  Wi_Fi("Wi-Fi"),
  TV("TV"),
  Shower("Shower"),
  Swiming_Pool("Swimming Pool"),
  Hot_Tub("Hot Tub"),
  Heating("Heating"),
  Fire_Alarm("Fire Alarm"),
  Carbon_Monoxide_Alarm("Carbon Monoxide Alarm"),
  Transport_Links("Transport Links");

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  private String value;

  Amenity(String value) {
    this.value = value;
  }

  public static Amenity of(String value) {
    return Stream.of(Amenity.values())
        .filter(amenity -> amenity.getValue() == value)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public String getValue() {
    return value;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
