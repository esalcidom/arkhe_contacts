package com.esalcido.arkhe.contacts.arkhe_contacts.services;

import java.util.List;
import java.util.Optional;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AddressService
 */
@Service("addressService")
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CityService cityService;

    public AddressService(AddressRepository addressRepository, CityService cityService){
        this.addressRepository = addressRepository;
        this.cityService = cityService;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Optional<Address> findById(long id){
        return addressRepository.findById(id);
    }

    public Address save(Address address){

        if(cityService.findByName(address.getCity().getName()) == null)
            address.setCity(cityService.save(address.getCity()));
        return addressRepository.save(address);
    }

    public void deleteById(long id){
        addressRepository.deleteById(id);
    }
}