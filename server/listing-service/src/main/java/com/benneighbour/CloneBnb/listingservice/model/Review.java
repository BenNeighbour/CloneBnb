package com.benneighbour.CloneBnb.listingservice.model;

import com.benneighbour.CloneBnb.listingservice.common.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 15/08/2020
 * @project CloneBnb
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "Review")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review implements Serializable {

  private static final long serialVersionUID = 425360301873542089L;

  @Id
  @GeneratedValue
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(columnDefinition = "uuid", updatable = false)
  private UUID reviewId;

  @Column(name = "stars")
  private Integer stars;

  @Column(name = "comment")
  private String comment;

  @JsonIgnore
  @Column(name = "reviewerId")
  private UUID reviewerId;

  @Transient
  private User reviewer;
}

