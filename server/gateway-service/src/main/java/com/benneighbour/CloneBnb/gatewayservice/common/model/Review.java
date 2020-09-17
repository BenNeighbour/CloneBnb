package com.benneighbour.CloneBnb.gatewayservice.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
public class Review implements Serializable {

  private static final long serialVersionUID = -7513717085844984944L;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;

  private Integer stars;

  private String comment;

  private UUID reviewerId;

  public Review() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Integer getStars() {
    return stars;
  }

  public void setStars(Integer stars) {
    this.stars = stars;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public UUID getReviewerId() {
    return reviewerId;
  }

  public void setReviewerId(UUID reviewerId) {
    this.reviewerId = reviewerId;
  }
}
