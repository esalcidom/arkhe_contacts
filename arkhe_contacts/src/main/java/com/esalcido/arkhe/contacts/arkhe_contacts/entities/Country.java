package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Country
 */
@Entity
@Table(name="COUNTRY")
public class Country {

    @Id
    @Column(name="COUNTRY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    @Column(name="NAME")
    private String name;


    public Country() {
    }

    public Country(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country countryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Country)) {
            return false;
        }
        Country country = (Country) o;
        return countryId == country.countryId && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, name);
    }

    @Override
    public String toString() {
        return "{" +
            " countryId='" + getCountryId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}