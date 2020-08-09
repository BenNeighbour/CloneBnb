package com.benneighbour.CloneBnb.gatewayservice.common.security;

import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class AuthenticationEntryPoint
    implements org.springframework.security.web.AuthenticationEntryPoint {

  @Override
  public void commence(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AuthenticationException e)
      throws IOException {
    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getLocalizedMessage());
  }
}
