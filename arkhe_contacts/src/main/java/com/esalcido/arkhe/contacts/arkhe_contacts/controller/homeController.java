package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @Autowired
    private ContactRepository contactRepostitory;
    // @Autowired
    // private AddressRepository addressRepository;
    // @Autowired
    // private CityRepository cityRepository;
    // @Autowired
    // private ContactIdentRepository contactIdentRepository;
    // @Autowired
    // private GenderRepository genderRepository;
    // @Autowired
    // private StateRepository stateRepository;
    // @Autowired
    // private TaxRefRepository taxRefRepository;

    @GetMapping("/home")
    public String getContacts(Model model) {
        model.addAttribute("contacts", contactRepostitory.findAll());
        return "home";
    }

}
