package com.esalcido.arkhe.contacts.arkhe_contacts.security;

import javax.sql.DataSource;

import com.esalcido.arkhe.contacts.arkhe_contacts.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * SecurityConfiguration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().antMatchers("/api/*","/js/**","/css/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
        http.authorizeRequests().antMatchers("/", "/**").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login");
        http.cors().and().csrf().disable();
        // .failureUrl("/login?error=true").defaultSuccessUrl("/home").and().logout()
        // .logoutRequestMatcher(new
        // AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("sa").password("sa").roles("USER");
        // auth.userDetailsService(userDetailsService);
    }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    // web
    // .ignoring()
    // .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
    // "/images/**");
    // }
}