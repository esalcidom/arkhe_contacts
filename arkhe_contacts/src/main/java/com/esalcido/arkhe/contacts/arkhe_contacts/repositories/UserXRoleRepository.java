package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.UserXRole;

@Repository("userXRoleRepository")
public interface UserXRoleRepository extends JpaRepository<UserXRole,Long>{
    UserXRole findByUserId(String userId);
}