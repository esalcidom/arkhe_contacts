package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * ContactRestController
 */
@RestController
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/rest/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id) {
        return contactRepository.findById(id);
    }

    @RequestMapping(value = "/rest/contact", method = RequestMethod.POST)
    public ResponseEntity<Object> createContact(@RequestBody Contact newContact) {
        Contact savedContact = contactRepository.save(newContact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedContact.getContactId()).toUri();
        return ResponseEntity.created(location).build();
    }

}