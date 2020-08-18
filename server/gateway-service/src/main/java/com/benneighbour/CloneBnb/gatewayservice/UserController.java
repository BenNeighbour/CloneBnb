package com.benneighbour.CloneBnb.gatewayservice;

import com.benneighbour.CloneBnb.gatewayservice.common.dao.GlobalDao;
import com.benneighbour.CloneBnb.gatewayservice.dao.UserDao;
import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.benneighbour.CloneBnb.gatewayservice.model.role.Role;
import com.benneighbour.CloneBnb.gatewayservice.model.securityUser.SecurityUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 08/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/")
public class UserController {

  private final UserDao userDao;

  private final GlobalDao globalDao;

  private final ObjectMapper mapper;

  public UserController(
      final UserDao userDao, final GlobalDao globalDao, final ObjectMapper mapper) {
    this.userDao = userDao;
    this.globalDao = globalDao;
    this.mapper = mapper;
  }

  @PostMapping("auth/signup/")
  public User signup(@Valid @RequestBody User user) {
    user.setAccountEnabled(true);

    Role role = new Role();
    role.setRoleType("USER");
    user.setRole(new ArrayList<>());
    user.getRole().add(role);

    return userDao.save(user);
  }

  @GetMapping("auth/me/")
  public ResponseEntity<Object> getUserById(Authentication authentication) throws Exception {
    User user = userDao.findUserByUsername(authentication.getName());
    return ResponseEntity.ok(globalDao.getUserById(user.getId()));
  }

  @GetMapping("internal/by/{id}")
  public User getUserById(@PathVariable("id") UUID id) throws Exception {
    return globalDao.getUserById(id);
  }

}
