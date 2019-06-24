package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.TaxRef;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TaxRefRepository
 */
@Repository("TaxRefRepostory")
public interface TaxRefRepository extends CrudRepository<TaxRef, Integer>{

    
}