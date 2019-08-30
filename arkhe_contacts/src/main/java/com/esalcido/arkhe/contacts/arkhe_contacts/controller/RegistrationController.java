package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.UserRepository;
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
    
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("form", new RegistrationForm());
        return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("form") RegistrationForm form, BindingResult result, SessionStatus status) {
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}