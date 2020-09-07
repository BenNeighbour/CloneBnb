package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Stay;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CompletableFuture;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
public interface ListingService {

    CompletableFuture<Listing> createListing(Listing listing);

    Listing saveListingFromCommand(CreateListingCommand command) throws IllegalAccessException, InvocationTargetException, Exception;

    Stay createStay(Stay stay);

}
