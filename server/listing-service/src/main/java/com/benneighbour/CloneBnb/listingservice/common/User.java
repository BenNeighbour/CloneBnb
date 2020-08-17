package com.benneighbour.CloneBnb.listingservice.common;

import com.benneighbour.CloneBnb.listingservice.model.Stay;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class User implements Serializable {

  private static final long serialVersionUID = -2229916935310862092L;

  private UUID id;

  private String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  private String phoneNumber;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Date dateOfBirth;

  private List<Stay> stays;

  @JsonIgnore
  private Boolean accountEnabled = false;

  @JsonIgnore
  private Boolean credentialsNonExpired = true;

  @JsonIgnore
  private Boolean accountNonExpired = true;

  @JsonIgnore
  private Boolean accountNonLocked = true;

  @JsonIgnore
  private Date created;

  @JsonIgnore
  private Date updated;

  public User() {}

  public User(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.accountEnabled = user.getAccountEnabled();
    this.credentialsNonExpired = user.getCredentialsNonExpired();
    this.accountNonExpired = user.getAccountNonExpired();
    this.accountNonLocked = user.getAccountNonLocked();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Boolean getAccountEnabled() {
    return accountEnabled;
  }

  public void setAccountEnabled(Boolean accountEnabled) {
    this.accountEnabled = accountEnabled;
  }

  public Boolean getCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public Boolean getAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(Boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public Boolean getAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(Boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Stay> getStays() {
    return stays;
  }

  public void setStays(List<Stay> stays) {
    this.stays = stays;
  }
}
