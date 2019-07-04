package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CityRepository
 */
@Repository("cityRepository")
public interface CityRepository extends JpaRepository<City, Integer>{

    City findByName(String city);
}