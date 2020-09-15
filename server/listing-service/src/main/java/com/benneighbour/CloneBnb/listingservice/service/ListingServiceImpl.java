package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.ReviewDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Review;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Ben Neighbour
 * @created 04/09/2020
 * @project CloneBnb
 */
@Service
public class ListingServiceImpl implements ListingService {

  private final ListingDao dao;

  private final StayDao stayDao;

  private final CommandGateway gateway;

  private final ReviewDao reviewDao;

  public ListingServiceImpl(
      final ListingDao dao,
      final CommandGateway gateway,
      final StayDao stayDao,
      final ReviewDao reviewDao) {
    this.dao = dao;
    this.gateway = gateway;
    this.stayDao = stayDao;
    this.reviewDao = reviewDao;
  }

  @Override
  public CompletableFuture<Listing> createListing(Listing listing) {
    try {
      CreateListingCommand createListing = new CreateListingCommand();
      BeanUtils.copyProperties(createListing, listing);

      return gateway.send(createListing);
    } catch (Exception e) {
      // TODO: Clean this up with listing response objects!
      throw new RuntimeException("NOT RIGHT!");
    }
  }

  @Override
  public Listing saveListingFromCommand(CreateListingCommand command)
      throws IllegalAccessException, InvocationTargetException, Exception {
    Listing listing = new Listing();
    BeanUtils.copyProperties(listing, command);

    return dao.save(listing);
  }

  @Override
  public Stay createStay(Stay stay) {
    return stayDao.save(stay);
  }

  @Override
  public ResponseEntity<Review> postReview(Review review) {
    return ResponseEntity.ok(reviewDao.save(review));
  }

  @Override
  public ResponseEntity<List<Stay>> getUnreviewedStays(UUID userId) {
    List<Stay> stays = stayDao.findAllStaysByUserId(userId);
    stays =
        stays.stream()
            .filter(stay -> stay.getReview() == null)
            .collect(Collectors.toList());

    return ResponseEntity.ok(stays);
  }
}
