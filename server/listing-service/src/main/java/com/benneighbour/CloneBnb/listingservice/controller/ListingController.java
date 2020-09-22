package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.common.GlobalDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.ListingSpecificationBuilder;
import com.benneighbour.CloneBnb.listingservice.model.SearchOperation;
import com.benneighbour.CloneBnb.listingservice.service.ListingService;
import com.google.common.base.Joiner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class ListingController {

  private final GlobalDao dao;

  private final ListingService service;

  public ListingController(final GlobalDao dao, final ListingService service) {
    this.dao = dao;
    this.service = service;
  }

  @GetMapping("internal/by/{listingId}")
  public Listing findListingById(@PathVariable("listingId") UUID id) {
    return dao.getListingById(id);
  }

  @GetMapping("listing/by/{listingId}")
  public Listing findListingByIdExternal(@PathVariable("listingId") UUID id) {
    return dao.getListingById(id);
  }

  @GetMapping("listing/search")
  public List<Listing> searchForListings(
      @RequestParam("query") String query,
      @RequestParam("checkIn") String checkIn,
      @RequestParam("checkOut") String checkOut) {

    ListingSpecificationBuilder builder = new ListingSpecificationBuilder();

    String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
    Pattern pattern =
        Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
    Matcher matcher = pattern.matcher(query + ",");
    while (matcher.find()) {
      builder.with(
          matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
    }

    Specification<Listing> specification = builder.build();
    List<Listing> compatibleListings =
        dao.findAllListings(specification).stream()
            .filter(
                listing ->
                        (checkIn).equals("") || (checkOut).equals("") || this.isWithinRange(
                                LocalDate.parse(checkIn),
                                LocalDate.parse(checkOut),
                                listing.getUnvacantDates()))
            .collect(Collectors.toList());

    compatibleListings.forEach(listing -> listing.setUnvacantDates(null));

    return compatibleListings;
  }

  @PostMapping("listing/create")
  public CompletableFuture<Listing> saveListing(@RequestBody Listing listing) {
    return service.createListing(listing);
  }

  private boolean isWithinRange(LocalDate checkIn, LocalDate checkOut, List<LocalDate> testDates) {
    boolean returnBool = false;
    for (int i = 0; i < testDates.size(); i++) {
      returnBool = (testDates.get(i).isBefore(checkIn) || testDates.get(i).isAfter(checkOut));
    }

    return returnBool;
  }
}
