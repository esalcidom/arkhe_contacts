package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import java.util.List;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AddressRestController
 */
@RestController
public class AddressRestController {

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "/rest/addresses", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }
}