package com.benneighbour.CloneBnb.gatewayservice.model;

import com.benneighbour.CloneBnb.gatewayservice.common.model.Stay;
import com.benneighbour.CloneBnb.gatewayservice.model.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
@Entity
@Table(name = "user_account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

  private static final long serialVersionUID = 6642429033663680780L;

  @Id
  @GeneratedValue
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Column(columnDefinition = "uuid", updatable = false)
  private UUID id;

  @Column(name = "username", unique = true)
  @NotEmpty(message = "Please enter a username")
  private String username;

  @Column(name = "password")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @NotEmpty(message = "Please enter a password")
  private String password;

  @Column(name = "number")
  private String phoneNumber;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(name = "dob")
  private Date dateOfBirth;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Role.class)
  @JsonIgnore
  private List<Role> role;

  @Transient private List<Stay> stays;

  @Column(name = "enabled")
  @JsonIgnore
  private Boolean accountEnabled = false;

  @Column(name = "credentialsNonExpired")
  @JsonIgnore
  private Boolean credentialsNonExpired = true;

  @Column(name = "nonExpired")
  @JsonIgnore
  private Boolean accountNonExpired = true;

  @Column(name = "nonLocked")
  @JsonIgnore
  private Boolean accountNonLocked = true;

  @CreationTimestamp
  @Column(name = "created", updatable = false, nullable = false)
  @JsonIgnore
  private Date created;

  @UpdateTimestamp
  @Column(name = "updated")
  @JsonIgnore
  private Date updated;

  public User() {}

  public User(User user) {
    this.id = user.getId();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.role = user.getRole();
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

  public List<Role> getRole() {
    return role;
  }

  public void setRole(List<Role> role) {
    this.role = role;
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
