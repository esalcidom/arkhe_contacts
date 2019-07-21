package com.esalcido.arkhe.contacts.arkhe_contacts.services;

import java.util.List;
import java.util.Optional;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ContactService
 */
@Service("contactService")
public class ContactService{

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AddressService addressService;
    
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Optional<Contact> findById(long id){
        return contactRepository.findById(id);
    }

    public Contact save(Contact contact){
        if(!addressService.findById(contact.getAddress().getAddressId()).isPresent())
            contact.setAddress(addressService.save(contact.getAddress()));
        return contactRepository.save(contact);
    }

    public void deleteById(long id){
        addressService.deleteById(contactRepository.findById(id).get().getAddress().getAddressId());
        contactRepository.deleteById(id);
    }
}