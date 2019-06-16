package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Gender
 */
@Entity
@Table(name = "TABLE_GENDER")
public class Gender {

    @Id
    @Column(name = "GENDER_ID")
    @GeneratedValue
    private int genderId;
    @Column(name = "GENDER_NAME")
    private String name;
    @OneToOne(mappedBy = "gender")
    private Contact contact;

    public Gender() {
    }

    public Gender(int genderId, String name) {
        this.genderId = genderId;
        this.name = name;
    }

    public int getGenderId() {
        return this.genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender genderId(int genderId) {
        this.genderId = genderId;
        return this;
    }

    public Gender name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Gender)) {
            return false;
        }
        Gender gender = (Gender) o;
        return genderId == gender.genderId && Objects.equals(name, gender.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId, name);
    }

    @Override
    public String toString() {
        return "{" + " genderId='" + getGenderId() + "'" + ", name='" + getName() + "'" + "}";
    }

}