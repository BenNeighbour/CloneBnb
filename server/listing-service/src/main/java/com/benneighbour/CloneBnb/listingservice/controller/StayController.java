package com.benneighbour.CloneBnb.listingservice.controller;

import com.benneighbour.CloneBnb.listingservice.dao.StayDao;
import com.benneighbour.CloneBnb.listingservice.model.Stay;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class StayController {

  private final StayDao dao;

  public StayController(final StayDao dao) {
    this.dao = dao;
  }

  // Get a stay by it's id
  @GetMapping("listing/stay/by/{id}")
  public Stay findStayById(@PathVariable("id") UUID id) {
    return dao.findStayById(id);
  }

  // Get the user stays
  @GetMapping("listing/stay/by/user/{id}")
  public ResponseEntity<List<Stay>> getUserStays(@PathVariable("id") UUID id) {
    List<Stay> stays = dao.findAllStaysByUserId(id);

    return ResponseEntity.ok(stays);
  }
}