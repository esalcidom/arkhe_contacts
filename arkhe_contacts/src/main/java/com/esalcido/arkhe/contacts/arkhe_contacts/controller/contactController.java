package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactIdentRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.GenderRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.StateRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.TaxRefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

/**
 * contactController
 */
@Controller
public class contactController {

    @Autowired
    private ContactRepository contactRepostitory;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private TaxRefRepository taxRefRepository;
    @Autowired
    private ContactIdentRepository contactIdentRepository;

    @GetMapping("/contact/new")
    public String newContact(Model model) {

        model.addAttribute("genderList", genderRepository.findAll());
        model.addAttribute("taxList", taxRefRepository.findAll());
        model.addAttribute("docList", contactIdentRepository.findAll());
        model.addAttribute("stateList", stateRepository.findAll());
        model.addAttribute("contact", new Context());
        return "contactform";
    }

    @GetMapping(value = "/contact/{id}")
    public String getContact(@PathVariable("id") String contact_id, Model model) {

        return "contactform";
    }

}