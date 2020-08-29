package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.listingservice.model.Listing;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
public interface ListingCommandService {

    CompletableFuture<String> createListing(Listing listing) throws Exception;

}
