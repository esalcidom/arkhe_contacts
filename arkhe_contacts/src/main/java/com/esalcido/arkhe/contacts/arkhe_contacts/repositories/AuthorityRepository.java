package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.Authority;

@Repository("authorityRepository")
public interface AuthorityRepository extends JpaRepository<Authority,Long>{
    
}