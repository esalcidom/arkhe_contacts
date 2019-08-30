package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esalcido.arkhe.contacts.arkhe_contacts.entities.User;

// @Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}