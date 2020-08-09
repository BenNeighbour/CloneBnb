package com.benneighbour.CloneBnb.gatewayservice.security;

import com.benneighbour.CloneBnb.gatewayservice.common.security.AuthenticationEntryPoint;
import com.benneighbour.CloneBnb.gatewayservice.common.security.JwtAuthenticationConfig;
import com.benneighbour.CloneBnb.gatewayservice.common.security.JwtAuthenticationFilter;
import com.benneighbour.CloneBnb.gatewayservice.common.security.JwtUsernamePasswordAuthenticationFilter;
import com.benneighbour.CloneBnb.gatewayservice.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Ben Neighbour
 * @created 07/08/2020
 * @project CloneBnb
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private JwtAuthenticationConfig config;

  @Autowired private SecurityUserService securityUserService;

  @Bean
  public JwtAuthenticationFilter authenticationFilter() {
    return new JwtAuthenticationFilter();
  }

  @Bean
  public JwtAuthenticationConfig jwtConfig() {
    return new JwtAuthenticationConfig();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(securityUserService).passwordEncoder(passwordEncoder());
  }

  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf()
        .disable()
        .logout()
        .disable()
        .formLogin()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .anonymous()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new AuthenticationEntryPoint())
        .and()
        .authorizeRequests()
        .antMatchers("/auth/must/auth/")
        .authenticated()
        .anyRequest()
        .permitAll()
        .and()
        .httpBasic()
        .disable();

    httpSecurity.addFilterAfter(
        new JwtUsernamePasswordAuthenticationFilter(config, authenticationManager()),
        UsernamePasswordAuthenticationFilter.class);

    httpSecurity.addFilterBefore(
        authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}
