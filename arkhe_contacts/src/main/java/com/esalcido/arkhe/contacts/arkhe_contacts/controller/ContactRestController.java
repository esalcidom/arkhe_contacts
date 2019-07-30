package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.error.ContactNotFoundException;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.AddressRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.CityRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    private ContactService contactService;
    // @Autowired
    // private CityRepository cityRepository;
    // @Autowired
    // private AddressRepository addressRepository;

    @RequestMapping(value = "/rest/contacts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public List<Contact> getContacts() {
        return contactService.findAll();
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<Contact> getContact(@PathVariable long id) {
        Optional<Contact> foundContact = contactService.findById(id);
        if (!foundContact.isPresent())
            throw new ContactNotFoundException("Not found ID -> " + id);
        return foundContact;
    }

    @RequestMapping(value = "/rest/contact", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> createContact(@RequestBody Contact newContact) {
        Contact savedContact = contactService.save(newContact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedContact.getContactId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteBook(@PathVariable Long id) {
        contactService.deleteById(id);
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.PUT, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> updateContact(@RequestBody Contact contact, @PathVariable Long id) {

        Optional<Contact> contactOptional = contactService.findById(id);
        if (!contactOptional.isPresent())
            throw new ContactNotFoundException("Not found ID -> " + id);
        contactService.save(contact);
        return ResponseEntity.noContent().build();
    }

}