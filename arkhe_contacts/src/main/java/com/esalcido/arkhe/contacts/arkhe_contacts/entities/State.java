package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * State
 */
@Entity
@Table(name="STATE")
public class State {

    @Id
    @Column(name="STATE_ID")
    @GeneratedValue
    private int stateId;
    @Column(name="NAME")
    private String name;


    public State() {
    }

    public State(int stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public int getStateId() {
        return this.stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State stateId(int stateId) {
        this.stateId = stateId;
        return this;
    }

    public State name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof State)) {
            return false;
        }
        State state = (State) o;
        return stateId == state.stateId && Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateId, name);
    }

    @Override
    public String toString() {
        return "{" +
            " stateId='" + getStateId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}