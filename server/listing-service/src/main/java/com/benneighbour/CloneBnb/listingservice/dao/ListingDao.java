package com.benneighbour.CloneBnb.listingservice.dao;

import com.benneighbour.CloneBnb.listingservice.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@Repository
public interface ListingDao extends JpaRepository<Listing, UUID>, JpaSpecificationExecutor<Listing> {

  Listing findListingById(UUID id);

}
