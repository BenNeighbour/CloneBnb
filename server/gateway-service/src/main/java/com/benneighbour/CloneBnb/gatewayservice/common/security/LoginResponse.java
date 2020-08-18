package com.benneighbour.CloneBnb.gatewayservice.common.security;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class LoginResponse {

  private STATUS STATUS;

  private String MESSAGE;

  public enum STATUS {
    SUCCESS,
    UNAUTHORIZED,
    INTERNAL_SERVER_ERROR
  }

  public LoginResponse.STATUS getSTATUS() {
    return STATUS;
  }

  public void setSTATUS(LoginResponse.STATUS STATUS) {
    this.STATUS = STATUS;
  }

  public String getMESSAGE() {
    return MESSAGE;
  }

  public void setMESSAGE(String MESSAGE) {
    this.MESSAGE = MESSAGE;
  }
}
