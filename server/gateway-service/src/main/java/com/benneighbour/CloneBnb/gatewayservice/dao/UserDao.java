package com.benneighbour.CloneBnb.gatewayservice.dao;

import com.benneighbour.CloneBnb.gatewayservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
@Repository
public interface UserDao extends JpaRepository<User, UUID> {

  User findUserByUsername(String username);

  User findUserById(UUID id);
}
