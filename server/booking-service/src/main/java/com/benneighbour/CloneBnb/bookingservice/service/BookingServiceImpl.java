package com.benneighbour.CloneBnb.bookingservice.service;

import com.benneighbour.CloneBnb.bookingservice.dao.BookingDao;
import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import com.benneighbour.CloneBnb.bookingservice.model.BookingResponse;
import com.benneighbour.CloneBnb.commonlibrary.command.CreateBookingCommand;
import com.benneighbour.CloneBnb.commonlibrary.model.Listing;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
@Service
public class BookingServiceImpl implements BookingService {

  private final BookingDao bookingDao;

  private final CommandGateway gateway;

  private final RestTemplate restTemplate;

  public BookingServiceImpl(
      final BookingDao bookingDao, final CommandGateway gateway, final RestTemplate restTemplate) {
    this.bookingDao = bookingDao;
    this.gateway = gateway;
    this.restTemplate = restTemplate;
  }

  @Override
  public CompletableFuture<String> makeBooking(Booking booking) {
    try {
      // Run check availability helper function
      boolean available =
          this.isBookingAvailable(
              booking.getCheckInDate(), booking.getCheckOutDate(), booking.getListingId());

      if (available) {
        // Dispatch command to gateway here
        CreateBookingCommand command = new CreateBookingCommand();
        BeanUtils.copyProperties(command, booking);

        return gateway.send(command);
      }

      // TODO: Inform the user that that booking is not valid if the frontend gets all the way there
      return null;
    } catch (Exception e) {
      // TODO: Throw exception up the callstack
      return null;
    }
  }

  @Override
  public ResponseEntity<BookingResponse> deleteBooking(UUID bookingId) {
    try {
      Booking bookingToRemove = bookingDao.findBookingByBookingId(bookingId);
      bookingDao.delete(bookingToRemove);

      BookingResponse response = new BookingResponse();
      response.setMESSAGE("BOOKING REMOVED");
      response.setSTATUS(BookingResponse.STATUS.SUCCESS);

      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      BookingResponse response = new BookingResponse();
      response.setMESSAGE("SOMETHING WENT WRONG...");
      response.setSTATUS(BookingResponse.STATUS.ERROR);

      return ResponseEntity.badRequest().body(response);
    }
  }

  @Override
  public Booking saveBooking(Booking booking) {
    return bookingDao.save(booking);
  }

  @Override
  public boolean isBookingAvailable(LocalDate checkInDate, LocalDate checkOutDate, UUID listingId) {
    // Get the available dates based on the two input stays
    long numberOfDaysBetween = ChronoUnit.DAYS.between(checkInDate, checkOutDate.plusDays(1));

    List<LocalDate> datesBetween =
        IntStream.iterate(0, i -> i + 1)
            .limit(numberOfDaysBetween)
            .mapToObj(checkInDate::plusDays)
            .collect(Collectors.toList());

    // Get the listing by the passed in id
    Listing listing =
        restTemplate.getForObject("http://listing-service/internal/by/" + listingId, Listing.class);

    for (int i = 0; i < datesBetween.size(); i++) {
      if (listing.getUnvacantDates().contains(datesBetween.get(i))) return false;
    }

    return true;
  }
}
