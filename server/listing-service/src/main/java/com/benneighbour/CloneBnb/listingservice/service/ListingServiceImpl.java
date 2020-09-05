package com.benneighbour.CloneBnb.listingservice.service;

import com.benneighbour.CloneBnb.commonlibrary.command.CreateListingCommand;
import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CompletableFuture;

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

  public ListingServiceImpl(
      final ListingDao dao, final CommandGateway gateway, final StayDao stayDao) {
    this.dao = dao;
    this.gateway = gateway;
    this.stayDao = stayDao;
  }

  @Override
  public CompletableFuture<Listing> createListing(Listing listing) {
    try {
      CreateListingCommand createListing = new CreateListingCommand();

      // TODO: CLEAN THIS UP!!!!!!!
      createListing.setAddress(listing.getAddress());
      createListing.setName(listing.getName());
      createListing.setAverageStars(listing.getAverageStars());
      createListing.setDescription(listing.getDescription());
      createListing.setLongDescription(listing.getLongDescription());
      createListing.setLocation(listing.getLocation());
      createListing.setNumberOfBathrooms(listing.getNumberOfBathrooms());
      createListing.setNumberOfBedrooms(listing.getNumberOfBedrooms());
      createListing.setNumberOfBeds(listing.getNumberOfBeds());
      createListing.setNumberOfGuests(listing.getNumberOfGuests());
      createListing.setOwnerId(listing.getOwnerId());
      createListing.setPricePerNight(listing.getPricePerNight());
      createListing.setThumbnailUrl(listing.getThumbnailUrl());
      createListing.setType(CreateListingCommand.PropertyType.Apartment);

      return gateway.send(createListing);
    } catch (Exception e) {
      // TODO: Clean this up with listing response objects!
      throw new RuntimeException("NOT RIGHT!");
    }
  }

  @Override
  public void reflectionHelper(Object src, Object dest)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
          SecurityException {
    for (Field field : src.getClass().getFields()) {
      if (!field.getName().equals("serialVersionUID") && !field.getName().equals("listingId")) {
        Field destField = dest.getClass().getField(field.getName());
        System.out.println(destField.getName());
      }
    }
  }

  @Override
  public void saveListingFromCommand(CreateListingCommand command)
      throws IllegalAccessException, InvocationTargetException, Exception {
    Listing listing = new Listing();
    BeanUtils.copyProperties(listing, command);

    dao.save(listing);
  }

  private void copyObject(Listing src, CreateListingCommand dest)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
          SecurityException {
    for (Field field : src.getClass().getFields()) {
      if (!field.getName().equals("serialVersionUID") && !field.getName().equals("listingId"))
        dest.getClass().getField(field.getName()).set(dest, field.get(src));
    }
  }

  @Override
  public void createStay(Stay stay) {
    stayDao.save(stay);
  }
}
