package com.benneighbour.CloneBnb.sagaeventservice.events;

import com.benneighbour.CloneBnb.sagaeventservice.common.Listing;
import com.benneighbour.CloneBnb.sagaeventservice.status.ListingStatus;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
public class ListingCreatedEvent extends Listing {

  public UUID listingId;

  public ListingStatus listingStatus;

  public ListingCreatedEvent(Object listing, UUID listingId, ListingStatus listingStatus) {
    super((Listing) listing);
    this.listingId = listingId;
    this.listingStatus = listingStatus;
  }

  public UUID getListingId() {
    return listingId;
  }

  public void setListingId(UUID listingId) {
    this.listingId = listingId;
  }

  public ListingStatus getListingStatus() {
    return listingStatus;
  }

  public void setListingStatus(ListingStatus listingStatus) {
    this.listingStatus = listingStatus;
  }
}
