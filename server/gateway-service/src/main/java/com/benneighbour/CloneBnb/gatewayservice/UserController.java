package com.benneighbour.CloneBnb.gatewayservice;

import com.benneighbour.CloneBnb.gatewayservice.common.dao.GlobalDao;
import com.benneighbour.CloneBnb.gatewayservice.dao.UserDao;
import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.benneighbour.CloneBnb.gatewayservice.model.role.Role;
import org.springframework.web.bind.annotation.*;

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

  private final UserDao userDao;

  private final GlobalDao globalDao;

  public UserController(final UserDao userDao, final GlobalDao globalDao) {
    this.userDao = userDao;
    this.globalDao = globalDao;
  }

  @PostMapping("signup/")
  public User signup(@Valid @RequestBody User user) {
    user.setAccountEnabled(true);

    Role role = new Role();
    role.setRoleType("USER");
    user.setRole(new ArrayList<>());
    user.getRole().add(role);

    return userDao.save(user);
  }

  @GetMapping("me/{id}")
  public User getUserById(@PathVariable("id") String id) throws Exception {
    return globalDao.getUserById(id);
  }
}
