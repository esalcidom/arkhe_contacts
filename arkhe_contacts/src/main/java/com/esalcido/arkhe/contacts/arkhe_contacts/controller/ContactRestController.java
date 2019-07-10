package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.AddressRepository;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.CityRepository;
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
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AddressRepository addressRepository;

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
        Address address = newContact.getAddress();
        City city = (cityRepository.findByName(address.getCity().getName().toUpperCase()));
        if (city == null) {
            city = cityRepository.save(address.getCity());
        }
        address.setCity(city);
        address = addressRepository.save(address);
        newContact.setAddress(address);
        Contact savedContact = contactRepository.save(newContact);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedContact.getContactId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }

    @RequestMapping(value = "/rest/contact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContact(@RequestBody Contact contact, @PathVariable Long id) {

        Optional<Contact> contactOptional = contactRepository.findById(id);
        if (!contactOptional.isPresent())
            return ResponseEntity.notFound().build();
        contact.setContactId(id);
        contactRepository.save(contact);
        return ResponseEntity.noContent().build();
    }

}