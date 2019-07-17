package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Gender
 */
@Entity
@Table(name = "TABLE_GENDER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Gender{

    @Id
    @Column(name = "GENDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    @NotNull
    @Size(min=1, max=20, message="Gender type should be between 1 and 20 characters long")
    @Column(name = "GENDER_NAME")
    private String name;
    // @OneToOne(mappedBy = "gender")
    // private Contact contact;

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