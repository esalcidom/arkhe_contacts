package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.TaxRef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TaxRefRepository
 */
@Repository("TaxRefRepostory")
public interface TaxRefRepository extends JpaRepository<TaxRef, Integer>{

    
}