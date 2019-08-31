package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Authority;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.AuthorityType;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

/**
 * RegistrationForm
 */
@Data
public class RegistrationForm {

    // private String firstName;
    // private String lastName;
    private String username;
    private String password;
    private Set<Authority> roles;

    public RegistrationForm(){
        
    }

    public RegistrationForm(String username, String password, Set<Authority> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public Set<Authority> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Authority> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // private String isActive;
    // private Date lastLogin;
    // private Date lastBadLogin;
    // private int badLoginCount;
    
    
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username, passwordEncoder.encode(this.password), roles);
    }
}