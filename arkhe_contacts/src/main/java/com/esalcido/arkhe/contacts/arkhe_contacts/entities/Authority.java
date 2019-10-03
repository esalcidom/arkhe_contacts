package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.esalcido.arkhe.contacts.arkhe_contacts.entities.AuthorityType;


/**
 * Role
 */
@Entity
@Table(name = "TABLE_AUTHORITY")
public class Authority {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {
    }

    public Authority(long id, AuthorityType name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AuthorityType getName() {
        return this.name;
    }

    public void setName(AuthorityType name) {
        this.name = name;
    }

    public Authority id(long id) {
        this.id = id;
        return this;
    }

    public Authority name(AuthorityType name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Authority)) {
            return false;
        }
        Authority authority = (Authority) o;
        return id == authority.id && Objects.equals(name, authority.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
   
    

}