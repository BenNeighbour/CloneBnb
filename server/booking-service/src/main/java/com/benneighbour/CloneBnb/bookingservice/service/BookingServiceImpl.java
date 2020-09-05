package com.benneighbour.CloneBnb.bookingservice.service;

import com.benneighbour.CloneBnb.bookingservice.dao.BookingDao;
import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import com.benneighbour.CloneBnb.bookingservice.model.BookingResponse;
import com.benneighbour.CloneBnb.commonlibrary.command.CreateBookingCommand;
import org.apache.commons.beanutils.BeanUtils;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
@Service
public class BookingServiceImpl implements BookingService {

  private final BookingDao bookingDao;

  private final CommandGateway gateway;

  public BookingServiceImpl(final BookingDao bookingDao, final CommandGateway gateway) {
    this.bookingDao = bookingDao;
    this.gateway = gateway;
  }

  @Override
  public ResponseEntity<BookingResponse> makeBooking(Booking booking) {
    try {
      // TODO: Run check availability helper function

      // Dispatch command to gateway here
      CreateBookingCommand command = new CreateBookingCommand();
      BeanUtils.copyProperties(command, booking);

      gateway.send(command);

      BookingResponse response = new BookingResponse();
      response.setMESSAGE("STAY BOOKED SUCCESSFULLY");
      response.setSTATUS(BookingResponse.STATUS.SUCCESS);
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      BookingResponse response = new BookingResponse();
      response.setMESSAGE("UNABLE TO BOOK STAY");
      response.setSTATUS(BookingResponse.STATUS.ERROR);

      return ResponseEntity.badRequest().body(response);
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
  public ResponseEntity<BookingResponse> checkBookingAvailability(Booking booking) {
    return null;
  }
}
