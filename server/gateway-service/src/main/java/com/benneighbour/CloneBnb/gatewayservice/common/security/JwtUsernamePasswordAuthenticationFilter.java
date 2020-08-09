package com.benneighbour.CloneBnb.gatewayservice.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class JwtUsernamePasswordAuthenticationFilter
    extends AbstractAuthenticationProcessingFilter {

  private final JwtAuthenticationConfig config;

  private final ObjectMapper mapper;

  public JwtUsernamePasswordAuthenticationFilter(
      JwtAuthenticationConfig config, AuthenticationManager authenticationManager) {
    super(new AntPathRequestMatcher("/auth/", "POST"));
    setAuthenticationManager(authenticationManager);

    this.config = config;
    this.mapper = new ObjectMapper();
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException {
    // Create a new token, and make sure to sign it with the right hashing algorithm
    Instant now = Instant.now();
    String token =
        Jwts.builder()
            .setSubject(authResult.getName())
            .claim(
                "authorities",
                authResult.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date())
            .setExpiration(Date.from(now.plus(10, ChronoUnit.DAYS)))
            .signWith(SignatureAlgorithm.HS256, config.getSecret().getBytes())
            .compact();

    LoginResponse resBody = new LoginResponse();
    resBody.setMESSAGE("Authenticated Successfully!");
    resBody.setSTATUS(LoginResponse.STATUS.SUCCESS);

    Cookie cookie = new Cookie("session", token);
    cookie.setDomain("localhost");
    cookie.setPath("/");
    cookie.setHttpOnly(true);
    cookie.setSecure(false);

    response.addCookie(cookie);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().write(mapper.writeValueAsString(resBody));

    response.getWriter().flush();
    response.getWriter().close();
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws AuthenticationException, IOException {

    // Read the login request values (username, password)
    LoginRequest loginRequest =
        mapper.readValue(httpServletRequest.getInputStream(), LoginRequest.class);
    return getAuthenticationManager()
        .authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword(), Collections.emptyList()));
  }
}
