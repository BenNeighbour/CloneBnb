package com.benneighbour.CloneBnb.bookingservice.service;

import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import com.benneighbour.CloneBnb.bookingservice.model.BookingResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
public interface BookingService {

  CompletableFuture<String> makeBooking(Booking booking);

  ResponseEntity<BookingResponse> deleteBooking(UUID bookingId);

  Booking saveBooking(Booking booking);

  boolean isBookingAvailable(LocalDate checkInDate, LocalDate checkOutDate, UUID listingId);
}
