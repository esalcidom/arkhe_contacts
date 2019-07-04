package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * GenderRepository
 */
@Repository("genderRepository")
public interface GenderRepository extends JpaRepository<Gender, Integer>{
    
}