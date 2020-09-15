package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.model.Review;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import com.benneighbour.CloneBnb.listingservice.service.ListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 12/09/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class ReviewController {

  private final ListingService service;

  public ReviewController(final ListingService service) {
    this.service = service;
  }

  @PostMapping("listing/review/save/")
  public ResponseEntity<Review> saveReview(@Valid @RequestBody Review review) {
    return service.postReview(review);
  }

  @GetMapping("listing/review/unreviewed/{id}")
  public ResponseEntity<List<Stay>> getUnreviewedStays(@PathVariable("id") UUID userId) {
    return service.getUnreviewedStays(userId);
  }
}
