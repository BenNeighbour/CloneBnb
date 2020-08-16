package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/listing")
public class ListingController {

  private final ListingDao dao;

  public ListingController(final ListingDao dao) {
    this.dao = dao;
  }

  @GetMapping("/by/{id}")
  public Listing findListingById(@PathVariable("id") UUID id) {
    // Get the listing:
    // All the info is there apart from the user to be filled in

    // Call global dao to get the user by the owner id, setting that to
    Listing listing = dao.findListingById(id);
    //    listing.setOwner(listing.getOwnerId());

    return listing;
  }

}
