package com.benneighbour.CloneBnb.gatewayservice.common.dao;

import com.benneighbour.CloneBnb.gatewayservice.common.model.Stay;
import com.benneighbour.CloneBnb.gatewayservice.dao.UserDao;
import com.benneighbour.CloneBnb.gatewayservice.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 16/08/2020
 * @project CloneBnb
 */
@Component
public class GlobalDao {

  private final RestTemplate restTemplate;

  private final UserDao userDao;

  public GlobalDao(final RestTemplate restTemplate, final UserDao userDao) {
    this.restTemplate = restTemplate;
    this.userDao = userDao;
  }

  public User getUserById(UUID id) throws Exception {
    User user = userDao.findUserById(id);

    List<Stay> stays =
        Arrays.asList(
            restTemplate.getForObject(
                "http://listing-service/listing/stay/by/user/" + id, Stay[].class));

    user.setStays(stays);
    if (user.getStays() == null) user.setStays(new ArrayList<>());

    return user;
  }
}
