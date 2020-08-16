package com.benneighbour.CloneBnb.listingservice.common;

import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

  public GlobalDao(final RestTemplate restTemplate, final ListingDao listingDao, final StayDao stayDao) {
    this.restTemplate = restTemplate;
    this.listingDao = listingDao;
    this.stayDao = stayDao;
  }
}
