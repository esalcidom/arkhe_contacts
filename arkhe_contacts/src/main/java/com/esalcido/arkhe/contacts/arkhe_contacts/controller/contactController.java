package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactIdentRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.GenderRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.StateRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.TaxRefRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 * contactController
 */
@Controller
public class ContactController {

    // @Autowired
    // private ContactRepository contactRepostitory;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private TaxRefRepository taxRefRepository;
    @Autowired
    private ContactIdentRepository contactIdentRepository;
    // @Autowired
    // private CityRepository cityRepository;
    @Autowired
    private ContactService contactService;
    // @Autowired
    // private AddressRepository addressRepository;

    @GetMapping("/contact/new")
    public String newContact(Model model) {

        model.addAttribute("genderList", genderRepository.findAll());
        model.addAttribute("taxList", taxRefRepository.findAll());
        model.addAttribute("docList", contactIdentRepository.findAll());
        model.addAttribute("stateList", stateRepository.findAll());
        model.addAttribute("contact", new Contact());
        return "contactform";
    }

    @GetMapping(value = "/contact/{id}")
    public String getContact(@PathVariable("id") String contact_id, Model model) {

        model.addAttribute("genderList", genderRepository.findAll());
        model.addAttribute("taxList", taxRefRepository.findAll());
        model.addAttribute("docList", contactIdentRepository.findAll());
        model.addAttribute("stateList", stateRepository.findAll());
        model.addAttribute("contact", contactService.findById(Long.parseLong(contact_id)).get());
        return "contactform";
    }

    @PostMapping("/contact")
    public String updateContact(@ModelAttribute("contact") Contact contact, BindingResult result,
            SessionStatus status) {
        contactService.save(contact);
        return "redirect:/home";
    }

    @PostMapping("/contact/{id}")
    public String deleteContact(@ModelAttribute("contact") Contact cont, @PathVariable("id") String contact_id,
            BindingResult result, SessionStatus status) {
        contactService.deleteById(Long.parseLong(contact_id));
        return "redirect:/home";
    }

    }
             

