package com.benneighbour.CloneBnb.gatewayservice.common.security;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class JwtAuthenticationConfig {

  private String tokenValue;

  @Value("${clonebnb.security.jwt.secret}")
  private String secret;

  private Long duration = 5L;

  private int expiry = 50000;

  public JwtAuthenticationConfig() {}

  public JwtAuthenticationConfig(String tokenValue, Long duration, int expiry) {
    this.tokenValue = tokenValue;
    this.duration = duration;
    this.expiry = expiry;
  }

  public String getTokenValue() {
    return tokenValue;
  }

  public void setTokenValue(String tokenValue) {
    this.tokenValue = tokenValue;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public int getExpiry() {
    return expiry;
  }

  public void setExpiry(int expiry) {
    this.expiry = expiry;
  }
}
