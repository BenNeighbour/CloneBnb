package com.benneighbour.CloneBnb.gatewayservice.model.securityUser;

import com.benneighbour.CloneBnb.gatewayservice.model.User;
import com.benneighbour.CloneBnb.gatewayservice.model.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class SecurityUser extends User implements UserDetails {

  public SecurityUser() {}

  public SecurityUser(User user) {
    super(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> grantedAuthorities;
    grantedAuthorities = new ArrayList<>();

    for (Role role : super.getRole()) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleType()));
    }

    return grantedAuthorities;
  }

  @Override
  public UUID getId() {
    return super.getId();
  }

  @Override
  public String getPassword() {
    return super.getPassword();
  }

  @Override
  public String getUsername() {
    return super.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return super.getAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return super.getAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return super.getCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return super.getAccountEnabled();
  }
}
