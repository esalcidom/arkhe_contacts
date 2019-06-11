package com.esalcido.arkhe.contacts.arkhe_contacts.services;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.UserRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.UserXRoleRepository;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService{

    private UserRepository userRepository;
    private UserXRoleRepository userXRoleRepository;
    
    public UserService(UserRepository userRepository, UserXRoleRepository userXRoleRepository){
        this.userRepository = userRepository;
        this.userXRoleRepository = userXRoleRepository;
    }

    public User findByLoginName(String loginName){
        return userRepository.findByLoginName(loginName);
    }
}