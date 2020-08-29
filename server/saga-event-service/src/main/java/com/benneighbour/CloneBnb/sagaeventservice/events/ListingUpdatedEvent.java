package com.benneighbour.CloneBnb.sagaeventservice.events;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
public class ListingUpdatedEvent {

    public final UUID listingId;

    public final String listingStatus;

    public ListingUpdatedEvent(UUID listingId, String listingStatus) {
        this.listingId = listingId;
        this.listingStatus = listingStatus;
    }
}
