package com.esalcido.arkhe.contacts.arkhe_contacts.services;

import java.util.List;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.City;
import com.esalcido.arkhe.contacts.arkhe_contacts.repositories.CityRepository;

import org.springframework.stereotype.Service;

/**
 * CityService
 */
@Service("cityService")
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City findByName(String name){
        return cityRepository.findByName(name);
    }

    public City save(City city){
        return cityRepository.save(city);
    }

    public void deleteById(int id){
        cityRepository.deleteById(id);
    }
}