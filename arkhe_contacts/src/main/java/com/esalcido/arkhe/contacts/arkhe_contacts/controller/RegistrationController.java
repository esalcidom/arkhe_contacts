package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.util.HashSet;
import java.util.Set;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Authority;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 * RegistrationController
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthorityRepository authorityRepository;
    
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("form", new RegistrationForm());
        return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("form") RegistrationForm form, BindingResult result, SessionStatus status) {
        Authority userAuthority = authorityRepository.findById(1L).get();
        Set<Authority> roles = new HashSet<>();
        roles.add(userAuthority);
        form.setRoles(roles);
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}