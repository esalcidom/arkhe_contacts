package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.ContactIdent;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Gender;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.State;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.TaxRef;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
