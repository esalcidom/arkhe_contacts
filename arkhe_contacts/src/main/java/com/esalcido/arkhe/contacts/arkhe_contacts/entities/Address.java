package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address
 */
@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue
    private long AddressId;
    @Column(name="STREET")
    private String street;
    @Column(name="SUBURB")
    private String suburb;    
    @Column(name="NUMBER_EXT")
    private String numberExt;
    @Column(name="NUMER_INT")
    private String numberInt;
    @Column(name="ZIP_CODE")
    private String zipCode;
    @Column(name="REFERENCE")
    private String reference;
    @Column(name="CITY")
    private int city;
    @Column(name="STATE")
    private int state;
    @Column(name="COUNTRY")
    private int country;
    

    public Address() {
    }

    public Address(long AddressId, String street, String suburb, String numberExt, String numberInt, String zipCode, String reference, int city, int state, int country) {
        this.AddressId = AddressId;
        this.street = street;
        this.suburb = suburb;
        this.numberExt = numberExt;
        this.numberInt = numberInt;
        this.zipCode = zipCode;
        this.reference = reference;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public long getAddressId() {
        return this.AddressId;
    }

    public void setAddressId(long AddressId) {
        this.AddressId = AddressId;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNumberExt() {
        return this.numberExt;
    }

    public void setNumberExt(String numberExt) {
        this.numberExt = numberExt;
    }

    public String getNumberInt() {
        return this.numberInt;
    }

    public void setNumberInt(String numberInt) {
        this.numberInt = numberInt;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getCity() {
        return this.city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCountry() {
        return this.country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public Address AddressId(long AddressId) {
        this.AddressId = AddressId;
        return this;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    public Address suburb(String suburb) {
        this.suburb = suburb;
        return this;
    }

    public Address numberExt(String numberExt) {
        this.numberExt = numberExt;
        return this;
    }

    public Address numberInt(String numberInt) {
        this.numberInt = numberInt;
        return this;
    }

    public Address zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Address reference(String reference) {
        this.reference = reference;
        return this;
    }

    public Address city(int city) {
        this.city = city;
        return this;
    }

    public Address state(int state) {
        this.state = state;
        return this;
    }

    public Address country(int country) {
        this.country = country;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return AddressId == address.AddressId && Objects.equals(street, address.street) && Objects.equals(suburb, address.suburb) && Objects.equals(numberExt, address.numberExt) && Objects.equals(numberInt, address.numberInt) && Objects.equals(zipCode, address.zipCode) && Objects.equals(reference, address.reference) && city == address.city && state == address.state && country == address.country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(AddressId, street, suburb, numberExt, numberInt, zipCode, reference, city, state, country);
    }

    @Override
    public String toString() {
        return "{" +
            " AddressId='" + getAddressId() + "'" +
            ", street='" + getStreet() + "'" +
            ", suburb='" + getSuburb() + "'" +
            ", numberExt='" + getNumberExt() + "'" +
            ", numberInt='" + getNumberInt() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", reference='" + getReference() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }

}