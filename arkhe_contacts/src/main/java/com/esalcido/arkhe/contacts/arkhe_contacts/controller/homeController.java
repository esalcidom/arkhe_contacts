package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class homeController {

    @Autowired
    private ContactRepository contactRepostitory;

    @GetMapping("/home")
    public String getContacts(Model model){
        model.addAttribute("contacts", contactRepostitory.findAll());
        return "home";
    }

    @GetMapping("/contact/new")
    public String newContact(Model model){
        model.addAttribute("contact", new Contact());
        return "contactform";
    }

    @PostMapping("/contact")
    public String createContact(Contact contact, Model model){
        contactRepostitory.save(contact);
        return "redirect:/home";
    }
    
}