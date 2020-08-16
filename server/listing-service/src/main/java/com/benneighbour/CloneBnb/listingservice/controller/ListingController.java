package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.common.GlobalDao;
import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/listing")
public class ListingController {

  private final GlobalDao dao;

  public ListingController(final GlobalDao dao) {
    this.dao = dao;
  }

  @GetMapping("/by/{id}")
  public Listing findListingById(@PathVariable("id") UUID id) {
    return dao.getListingById(id);
  }

}
