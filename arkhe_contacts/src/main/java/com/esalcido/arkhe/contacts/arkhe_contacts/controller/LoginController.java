package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String goLogin(Model model){
        return "redirect:login";
    }

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

}