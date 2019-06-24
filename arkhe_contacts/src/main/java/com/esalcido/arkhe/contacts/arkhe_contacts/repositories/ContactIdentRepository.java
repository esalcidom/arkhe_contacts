package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.ContactIdent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ContactIdentRepository
 */
@Repository("contactIdentRepository")
public interface ContactIdentRepository extends CrudRepository<ContactIdent, Long>{

    
}