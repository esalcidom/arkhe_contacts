package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    // @PostMapping(value = {"/login"})
    // public String processRegistration(@ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
    //     User dbUser = userRepository.findByUsername(user.getUsername());
    //     if(dbUser != null && passwordEncoder.matches(user.getPassword(), dbUser.getPassword()))
    //         return "redirect:/home";
    //     else
    //         return "redirect:/loginFailed";
    // }
    
    // @RequestMapping(value={"/loginFailed"}, method = RequestMethod.GET)
    // public String getLoginFailedPage(){
    //     return "loginFailed";
    // }

}