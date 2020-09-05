package com.benneighbour.CloneBnb.commonlibrary.event;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateStayCommand;

import java.io.Serializable;

/**
 * @author Ben Neighbour
 * @created 05/09/2020
 * @project CloneBnb
 */
public class StayCreatedEvent extends CreateStayCommand implements Serializable {

  private static final long serialVersionUID = 5824218974784636538L;

  public StayCreatedEvent(CreateStayCommand command) {
    super(command);
  }
}
