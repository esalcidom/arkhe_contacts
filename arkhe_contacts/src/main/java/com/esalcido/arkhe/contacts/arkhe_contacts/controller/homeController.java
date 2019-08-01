package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.util.List;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/home")
    public String getContacts(@RequestParam(name = "filter", defaultValue = "") String fitler, Model model) {
        if(!fitler.equals(""))
            model.addAttribute("contacts", contactService.findByFirstNameContaining(fitler.toUpperCase()));
        else
            model.addAttribute("contacts", contactService.findAll());
        return "home";
    }

}
