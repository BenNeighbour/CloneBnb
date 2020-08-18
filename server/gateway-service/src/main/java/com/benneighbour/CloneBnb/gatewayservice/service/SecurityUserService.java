package com.benneighbour.CloneBnb.gatewayservice.service;

import com.benneighbour.CloneBnb.gatewayservice.dao.UserDao;
import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.benneighbour.CloneBnb.gatewayservice.model.securityUser.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
@Service
public class SecurityUserService implements UserDetailsService {

  private final UserDao dao;

  public SecurityUserService(final UserDao dao) {
    this.dao = dao;
  }

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    Optional<User> optionalUser = Optional.ofNullable(dao.findUserByUsername(name));
    optionalUser.orElseThrow(
        () -> new UsernameNotFoundException("Username or Password is incorrect"));

    UserDetails userDetails = new SecurityUser(optionalUser.get());
    new AccountStatusUserDetailsChecker().check(userDetails);

    return userDetails;
  }
}
