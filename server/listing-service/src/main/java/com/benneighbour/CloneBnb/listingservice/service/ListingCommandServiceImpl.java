package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.sagaeventservice.commands.CreateListingCommand;
import com.benneighbour.CloneBnb.sagaeventservice.events.ListingCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ben Neighbour
 * @created 29/08/2020
 * @project CloneBnb
 */
@Service
public class ListingCommandServiceImpl implements ListingCommandService {

  private final CommandGateway gateway;

  private final ListingDao listingDao;

  public ListingCommandServiceImpl(final CommandGateway gateway, final ListingDao listingDao) {
    this.gateway = gateway;
    this.listingDao = listingDao;
  }

  @Override
  public CompletableFuture<String> createListing(Listing listing) throws Exception {
//    CreateListingCommand command =
//        new CreateListingCommand(listing, listing.getId());

    try {
      return gateway.send(null);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  @EventHandler
  public void addListing(ListingCreatedEvent event) throws Exception {
    // TODO: Verify that this actually works!
    Listing listing = Listing.class.cast(event);

    listingDao.save(listing);
  }
}
