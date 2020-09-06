package com.benneighbour.CloneBnb.listingservice.dao;

import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@Repository
public interface StayDao extends JpaRepository<Stay, UUID> {

  Stay findStayByStayId(UUID id);

  List<Stay> findAllStaysByUserId(UUID userId);

}
