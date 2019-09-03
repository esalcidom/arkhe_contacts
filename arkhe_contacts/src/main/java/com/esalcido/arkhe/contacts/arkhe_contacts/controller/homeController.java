package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import javax.servlet.http.HttpSession;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;
import com.esalcido.arkhe.contacts.arkhe_contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class homeController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/home")
    public String getContacts(@RequestParam(name = "filter", defaultValue = "") String fitler, Model model, HttpSession session) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User currentUser = ((User) authentication.getPrincipal());
        session.setAttribute("userId", currentUser.getId());
        model.addAttribute("currentUser", currentUser);
        if(!fitler.equals(""))
            model.addAttribute("contacts", contactService.findByFirstNameContaining(fitler.toUpperCase()));
        else
            model.addAttribute("contacts", contactService.findAll());
        return "home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus session){
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/login";
    }

}
