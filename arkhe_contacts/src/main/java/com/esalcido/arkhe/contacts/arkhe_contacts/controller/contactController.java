package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.AddressRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.CityRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactIdentRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.GenderRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.StateRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.TaxRefRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

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
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AddressRepository addressRepository;

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
        model.addAttribute("contact", contactRepostitory.findById(Long.parseLong(contact_id)));
        return "contactform";
    }

    @PostMapping("/contact")
    public String createContact(@ModelAttribute("contact") Contact contact, BindingResult result,
            SessionStatus status) {
        if (contact.getContactId() > 0) {
            contactRepostitory.save(contact);
            return "redirect:/home";
        }
        Address address = contact.getAddress();
        City city = (cityRepository.findByName(address.getCity().getName().toUpperCase()));
        if (city == null) {
            city = cityRepository.save(address.getCity());
        }
        address.setCity(city);
        address = addressRepository.save(address);
        contact.setAddress(address);
        contactRepostitory.save(contact);
        return "redirect:/home";
    }

}