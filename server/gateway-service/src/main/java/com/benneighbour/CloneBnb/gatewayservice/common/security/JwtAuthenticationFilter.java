package com.benneighbour.CloneBnb.gatewayservice.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JwtAuthenticationConfig config;

  public JwtAuthenticationFilter() {}

  public JwtAuthenticationFilter(JwtAuthenticationConfig config) {
    this.config = config;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain)
      throws ServletException, IOException {
    try {
      if (!httpServletRequest.getServletPath().equals("/auth/")) {
        String jwt = this.getJwtFromCookie(httpServletRequest);

        // Validate and create the token, while adding it to the user's authentication session
        Claims claims =
            Jwts.parser()
                .setSigningKey(config.getSecret().getBytes())
                .parseClaimsJws(jwt)
                .getBody();

        String username = claims.getSubject();

        List<String> userAuthorities = claims.get("authorities", List.class);
        if (username != null) {
          UsernamePasswordAuthenticationToken authenticationToken =
              new UsernamePasswordAuthenticationToken(
                  username,
                  null,
                  userAuthorities.stream()
                      .map(SimpleGrantedAuthority::new)
                      .collect(Collectors.toList()));

          authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
      }
    } catch (Exception ex) {
      SecurityContextHolder.clearContext();
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

  private String getJwtFromCookie(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("session".equals(cookie.getName())) {
          return cookie.getValue();
        }
      }
    }

    return null;
  }
}
