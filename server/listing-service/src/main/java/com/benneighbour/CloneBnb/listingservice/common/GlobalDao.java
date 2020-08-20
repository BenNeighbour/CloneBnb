package com.benneighbour.CloneBnb.listingservice.common;

import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            "http://gateway-service/internal/owner/by/" + listing.getOwnerId().toString(),
            User.class);

    listing.setOwner(owner);

    this.stayHelper(listing);

    return listing;
  }

  // Get all of the listings with the search terms and their owners
  public List<Listing> findAllListings(Specification<Listing> specification) {
    List<Listing> listings = listingDao.findAll(specification);

    listings.forEach(
        listing -> {
          this.getListingById(listing.getId());
        });

    return listings;
  }

  // Helper method to get the available dates based on the stays
  private void stayHelper(Listing listing) {
    // Get all the stays that are vacant
    List<Stay> availableStays =
        stayDao.findAll().stream()
            // Filter based off if the current object actually belongs to the list
            .filter(stay -> stay.getListing().getId().equals(listing.getId()))

            // Filter again based of if the stay is not in progress
            .filter(stay -> !stay.isFinished())
            .collect(Collectors.toList());

    // Making the unvacant dates a new ArrayList
    listing.setUnvacantDates(new ArrayList<>());
    availableStays.forEach(
        stay -> {
          // Get all of the dates between the check in and check out date
          long numberOfDaysBetween =
              ChronoUnit.DAYS.between(stay.getCheckInDate(), stay.getCheckOutDate().plusDays(1));

          // For each of those dates, append them onto the available stays ArrayList<>()
          List<LocalDate> datesBetween =
              IntStream.iterate(0, i -> i + 1)
                  .limit(numberOfDaysBetween)
                  .mapToObj(i -> stay.getCheckInDate().plusDays(i))
                  .collect(Collectors.toList());

                    listing.getUnvacantDates().addAll(datesBetween);
        });
  }
}
