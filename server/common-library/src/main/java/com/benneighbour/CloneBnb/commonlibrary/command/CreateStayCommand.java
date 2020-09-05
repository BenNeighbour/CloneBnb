package com.benneighbour.CloneBnb.commonlibrary.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 05/09/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStayCommand implements Serializable {

  private static final long serialVersionUID = 7738048078949575845L;

  @TargetAggregateIdentifier private UUID stayId;

  private LocalDate checkInDate;

  private LocalDate checkOutDate;

  private boolean finished = false;

  private UUID userId;

  private UUID listingId;

  protected CreateStayCommand(CreateStayCommand command) {
    this.stayId = command.getStayId();
    this.checkInDate = command.getCheckInDate();
    this.checkOutDate = command.getCheckOutDate();
    this.finished = command.isFinished();
    this.userId = command.getUserId();
    this.listingId = command.getListingId();
  }
}
