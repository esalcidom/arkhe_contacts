package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Address
 */
@Entity
@Table(name = "TABLE_ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue
    private long AddressId;
    @Column(name = "STREET")
    private String street;
    @Column(name = "EXT_NUM")
    private String extNum;
    @Column(name = "INT_NUM")
    private String intNum;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "NEIGHBORHOOD")
    private String neighbordhood;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    private City city;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    private State state;
    @OneToOne(mappedBy = "address")
    private Contact contact;

    public Address() {
    }

    public Address(long AddressId, String street, String extNum, String intNum, String zipCode, int cityId,
            int stateiD) {
        this.AddressId = AddressId;
        this.street = street;
        this.extNum = extNum;
        this.intNum = intNum;
        this.zipCode = zipCode;
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

    public String getextNum() {
        return this.extNum;
    }

    public void setextNum(String extNum) {
        this.extNum = extNum;
    }

    public String getintNum() {
        return this.intNum;
    }

    public void setintNum(String intNum) {
        this.intNum = intNum;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return this.state;
    }

    public void setStateId(State state) {
        this.state = state;
    }

    public Address AddressId(long AddressId) {
        this.AddressId = AddressId;
        return this;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    public Address extNum(String extNum) {
        this.extNum = extNum;
        return this;
    }

    public Address intNum(String intNum) {
        this.intNum = intNum;
        return this;
    }

    public Address zipCode(String zipCode) {
        this.zipCode = zipCode;
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
        return AddressId == address.AddressId && Objects.equals(street, address.street)
                && Objects.equals(extNum, address.extNum) && Objects.equals(intNum, address.intNum)
                && Objects.equals(zipCode, address.zipCode) && city == address.city && state == address.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(AddressId, street, extNum, intNum, zipCode, city, state);
    }

    @Override
    public String toString() {
        return "{" + " AddressId='" + getAddressId() + "'" + ", street='" + getStreet() + "'" + "'" + ", extNum='"
                + getextNum() + "'" + ", intNum='" + getintNum() + "'" + ", zipCode='" + getZipCode() + "'"
                + ", reference='" + "'" + ", cityId='" + getCity() + "'" + ", state='" + getState() + "'" + "'"
                + "}";
    }

}