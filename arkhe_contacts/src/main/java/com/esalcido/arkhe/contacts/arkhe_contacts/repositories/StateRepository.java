package com.esalcido.arkhe.contacts.arkhe_contacts.repositories;

import java.util.List;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.State;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * StateRepository
 */
@Repository("stateRepository")
public interface StateRepository extends CrudRepository<State, Integer>{

    List<State> findAll();
}