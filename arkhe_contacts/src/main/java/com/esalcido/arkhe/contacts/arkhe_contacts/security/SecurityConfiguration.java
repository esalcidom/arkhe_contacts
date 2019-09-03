package com.esalcido.arkhe.contacts.arkhe_contacts.security;

import com.esalcido.arkhe.contacts.arkhe_contacts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
/**
 * SecurityConfiguration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  UserService userService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new StandardPasswordEncoder("53cr3t");
  }

  // @Bean
  // public DaoAuthenticationProvider authenticationProvider() {

  //   DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
  //   authProvider.setUserDetailsService(userService);
  //   authProvider.setPasswordEncoder(passwordEncoder());
  //   return authProvider;

  // }

  @Bean DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
    .authorizeRequests()
    .antMatchers("/login","/register", "/resources/**").access("permitAll")
    .and()
    .authorizeRequests()
    .antMatchers("/home","/contactform").hasAnyRole("USER", "ADMIN")
    .and()
    .formLogin().loginPage("/login")
    .loginProcessingUrl("/login")
    .defaultSuccessUrl("/home", true)
    .failureUrl("/loginFailed")
    .and()
    .csrf().ignoringAntMatchers("/h2-console/**")
    .and()  
    .headers()
    .frameOptions()
    .sameOrigin();
  }

}