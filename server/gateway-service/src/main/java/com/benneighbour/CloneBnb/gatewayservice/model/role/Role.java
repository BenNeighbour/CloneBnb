package com.benneighbour.CloneBnb.gatewayservice.model.role;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(generator = "uuid2")
  @Column(name = "id")
  private UUID id;

  @Column(name = "type")
  private String roleType = "USER";

  public Role() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getRoleType() {
    return roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }
}
