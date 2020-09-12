package com.benneighbour.CloneBnb.listingservice.dao;

import com.benneighbour.CloneBnb.listingservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 12/09/2020
 * @project CloneBnb
 */
@Repository
public interface ReviewDao extends JpaRepository<Review, UUID> {

    Review findReviewByReviewerId(UUID reviewId);

}
