package com.esalcido.arkhe.contacts.arkhe_contacts.security;

import com.esalcido.arkhe.contacts.arkhe_contacts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
// @EnableGlobalMethodSecurity(prePostEnabled = true)
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
    // auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    // .antMatchers("/home", "/contactform").access("hasRole('ROLE_USER')")
    .antMatchers("/home","/contactform").hasAnyRole("USER", "ADMIN")
    .and()
    .authorizeRequests().antMatchers("/resource/**","/**", "/", "/api/*","/js/**","/css/**").access("permitAll")
    .and()
    .formLogin().loginPage("/login")
    .defaultSuccessUrl("/home", true)
    .failureUrl("/loginFailed")
    .and()
    .csrf().ignoringAntMatchers("/h2-console/**")
    .and()  
    .headers()
    .frameOptions()
    .sameOrigin();
  }

  // @Autowired
  // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  //     //auth.inMemoryAuthentication().withUser("Asmsa1").password("Asmsa1").roles("USER");
  //     // auth.userDetailsService(userDetailsService);
  // }



  // @Override
  // protected void configure(AuthenticationManagerBuilder auth)
  //   throws Exception {
  //     auth
  //       .inMemoryAuthentication()
  //       .withUser("user")
  //         .password("{noop}password")
  //         .roles("USER")
  //         .and()
  //       .withUser("admin")
  //         .password("{noop}admin")
  //         .roles("USER", "ADMIN");
  // }

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //     http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
  // }
}