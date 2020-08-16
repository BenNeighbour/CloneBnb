package com.benneighbour.CloneBnb.listingservice.common;

import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@Component
public class GlobalDao {

  private final RestTemplate restTemplate;

  private final ListingDao listingDao;

  private final StayDao stayDao;

  public GlobalDao(
      final RestTemplate restTemplate, final ListingDao listingDao, final StayDao stayDao) {
    this.restTemplate = restTemplate;
    this.listingDao = listingDao;
    this.stayDao = stayDao;
  }

  // Fill in the owner field for the listing
  public Listing getListingById(UUID id) {
    Listing listing = listingDao.findListingById(id);

    // Get the user by the owner id field by making the cross-service call to gateway
    User owner =
        restTemplate.getForObject(
            "http://gateway-service/auth/by/" + listing.getOwnerId().toString(), User.class);

    listing.setOwner(owner);

    return listing;
  }
}
