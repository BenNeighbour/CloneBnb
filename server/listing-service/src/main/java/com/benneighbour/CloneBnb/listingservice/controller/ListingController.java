package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.common.GlobalDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.ListingSpecificationBuilder;
import com.benneighbour.CloneBnb.listingservice.model.SearchOperation;
import com.google.common.base.Joiner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class ListingController {

  private final GlobalDao dao;

  public ListingController(final GlobalDao dao) {
    this.dao = dao;
  }

  @GetMapping("internal/by/{id}")
  public Listing findListingById(@PathVariable("id") UUID id) {
    return dao.getListingById(id);
  }

  @GetMapping("listing/search")
  public List<Listing> searchForListings(@RequestParam("query") String query) {
    ListingSpecificationBuilder builder = new ListingSpecificationBuilder();

    String operationSetExper = Joiner.on("|")
            .join(SearchOperation.SIMPLE_OPERATION_SET);
    Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
    Matcher matcher = pattern.matcher(query + ",");
    while (matcher.find()) {
      builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
    }

    Specification<Listing> specification = builder.build();
    return dao.findAllListings(specification);
  }

}
