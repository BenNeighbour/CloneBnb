package com.benneighbour.CloneBnb.bookingservice.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

  private static final long serialVersionUID = -7513717085844984944L;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  private Integer stars;

  private String comment;

  private UUID reviewerId;

}
