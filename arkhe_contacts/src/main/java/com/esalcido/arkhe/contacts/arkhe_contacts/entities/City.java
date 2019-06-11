package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * City
 */
@Entity
@Table(name="CITY")
public class City {

    @Id
    @Column(name="CITY_ID")
    @GeneratedValue
    private int CityId;
    @Column(name="NAME")
    private String name;
    

    public City() {
    }

    public City(int CityId, String name) {
        this.CityId = CityId;
        this.name = name;
    }

    public int getCityId() {
        return this.CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City CityId(int CityId) {
        this.CityId = CityId;
        return this;
    }

    public City name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof City)) {
            return false;
        }
        City city = (City) o;
        return CityId == city.CityId && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CityId, name);
    }

    @Override
    public String toString() {
        return "{" +
            " CityId='" + getCityId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}