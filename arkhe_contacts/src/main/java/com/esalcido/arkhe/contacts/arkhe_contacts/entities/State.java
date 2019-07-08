package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * State
 */
@Entity
@Table(name = "TABLE_STATE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class State implements Serializable {

    @Id
    @Column(name = "STATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stateId;
    @Column(name = "STATE_NAME")
    private String name;
    // @OneToOne(mappedBy = "state")
    // private Address address;

    public State() {
    }

    public State(long stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public long getStateId() {
        return this.stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State state(long stateId) {
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
        return "{" + " stateId='" + getStateId() + "'" + ", name='" + getName() + "'" + "}";
    }

}