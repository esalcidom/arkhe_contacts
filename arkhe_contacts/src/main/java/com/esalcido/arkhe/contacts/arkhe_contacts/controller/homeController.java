package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.util.List;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/home")
    public String getContacts(Model model) {
        List<Contact> contactList =  contactService.findAll();
        model.addAttribute("contacts", contactList);
        return "home";
    }

}
