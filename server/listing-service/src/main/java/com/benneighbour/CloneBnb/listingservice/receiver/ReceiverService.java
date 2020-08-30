package com.benneighbour.CloneBnb.listingservice.receiver;

import com.benneighbour.CloneBnb.commonlibrary.Command;
import com.benneighbour.CloneBnb.commonlibrary.Message;
import com.benneighbour.CloneBnb.commonlibrary.SagaConverter;
import com.benneighbour.CloneBnb.listingservice.dao.ListingDao;
import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Listing;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Service
public class ReceiverService {

  @Autowired private ListingDao dao;

  @RabbitListener(queues = "#{queueA.name}")
  public Message executeCommand(Message message) {
    if (message.getCommand() == Command.UPDATE_LISTING_FOR_BOOK) {
      try {
        // Deserialize/Decode the content of the message containing the object information
        Stay stay = SagaConverter.decode(message.getContent(), Stay.class);


        // Do business logic / run methods that link to daos here
        Listing parentListing = stay.getListing();

        long numberOfDaysBetween =
            ChronoUnit.DAYS.between(stay.getCheckInDate(), stay.getCheckOutDate().plusDays(1));

        // For each of those dates, append them onto the available stays ArrayList<>()
        List<LocalDate> datesBetween =
            IntStream.iterate(0, i -> i + 1)
                .limit(numberOfDaysBetween)
                .mapToObj(i -> stay.getCheckInDate().plusDays(i))
                .collect(Collectors.toList());

        parentListing.getUnvacantDates().addAll(datesBetween);

        dao.saveAndFlush(parentListing);


        message.setFinished(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (message.getCommand() == Command.UPDATE_LISTING_FOR_BOOK_ROLLBACK) {
    }

    return message;
  }
}
