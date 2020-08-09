package com.benneighbour.CloneBnb.gatewayservice;

import com.benneighbour.CloneBnb.gatewayservice.dao.UserDao;
import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.benneighbour.CloneBnb.gatewayservice.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author Ben Neighbour
 * @created 08/08/2020
 * @project CloneBnb
 */
@RestController
@RequestMapping("/auth/")
public class UserController {

  @Autowired private UserDao userDao;

  @Autowired private PasswordEncoder encoder;

  @PostMapping("signup/")
  public User signup(@Valid @RequestBody User user) {
    user.setAccountEnabled(true);

    Role role = new Role();
    role.setRoleType("USER");
    user.setRole(new ArrayList<>());
    user.getRole().add(role);

    return userDao.save(user);
  }
}
