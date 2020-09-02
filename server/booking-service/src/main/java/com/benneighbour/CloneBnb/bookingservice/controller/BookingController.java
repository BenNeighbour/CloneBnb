package com.benneighbour.CloneBnb.bookingservice.controller;

import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import com.benneighbour.CloneBnb.bookingservice.model.BookingResponse;
import com.benneighbour.CloneBnb.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class BookingController {

    private final BookingService service;

    public BookingController(final BookingService service) {
        this.service = service;
    }

    @PostMapping("booking/book")
    public ResponseEntity<BookingResponse> book(@RequestBody Booking booking) {
        return service.makeBooking(booking);
    }

}
