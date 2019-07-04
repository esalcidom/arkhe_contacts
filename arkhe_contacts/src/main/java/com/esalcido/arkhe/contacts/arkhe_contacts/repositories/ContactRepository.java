package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Contact;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}