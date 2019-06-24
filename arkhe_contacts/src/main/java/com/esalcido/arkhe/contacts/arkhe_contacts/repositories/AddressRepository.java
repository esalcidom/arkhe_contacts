package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AddressRepository
 */
@Repository("addressRepository")
public interface AddressRepository extends CrudRepository<Address, Long>{

    
}