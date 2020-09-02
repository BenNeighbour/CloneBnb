package com.benneighbour.CloneBnb.bookingservice.dao;

import com.benneighbour.CloneBnb.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
@Repository
@Transactional
public interface BookingDao extends JpaRepository<Booking, UUID> {

    Booking findBookingById(UUID id);

    List<Booking> findAllBookingsByListingId(UUID listingId);

}
