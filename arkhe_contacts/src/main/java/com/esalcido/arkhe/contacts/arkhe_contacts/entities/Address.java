package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Address
 */
@Entity
@Table(name = "TABLE_ADDRESS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Address{

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    @NotNull
    @Size(min=1, max=50, message="Street should be between 1 and 50 characters long")
    @Column(name = "STREET")
    private String street;
    @NotNull
    @Size(min=1, max=10, message = "Exterior number should be between 1 and 10 characters long")
    @Column(name = "EXT_NUM")
    private String extNum;
    @Column(name = "INT_NUM")
    private String intNum;
    @NotNull
    @Size(min=1, max=10, message = "Zipcode should be between 1 and 10 character long")
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "NEIGHBORHOOD")
    private String neighbordhood;
    // @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", nullable = false)
    private City city;
    // @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID", nullable = false)
    private State state;
    // @OneToOne(mappedBy = "address")
    // private Contact contact;

    public Address() {
    }

    public Address(long AddressId, String street, String extNum, String intNum, String zipCode, City city,
            State state) {
        this.addressId = AddressId;
        this.street = street;
        this.extNum = extNum;
        this.intNum = intNum;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getNeighbordhood() {
        return this.neighbordhood;
    }

    public void setNeighbordhood(String neighbordhood) {
        this.neighbordhood = neighbordhood;
    }

    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long AddressId) {
        this.addressId = AddressId;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getExtNum() {
        return this.extNum;
    }

    public void setExtNum(String extNum) {
        this.extNum = extNum;
    }

    public String getIntNum() {
        return this.intNum;
    }

    public void setIntNum(String intNum) {
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

    public void setState(State state) {
        this.state = state;
    }

    public Address AddressId(long AddressId) {
        this.addressId = AddressId;
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
        return addressId == address.addressId && Objects.equals(street, address.street)
                && Objects.equals(extNum, address.extNum) && Objects.equals(intNum, address.intNum)
                && Objects.equals(zipCode, address.zipCode) && city == address.city && state == address.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, street, extNum, intNum, zipCode, city, state);
    }

    @Override
    public String toString() {
        return "{" + " AddressId='" + getAddressId() + "'" + ", street='" + getStreet() + "'" + "'" + ", extNum='"
                + getExtNum() + "'" + ", intNum='" + getIntNum() + "'" + ", zipCode='" + getZipCode() + "'"
                + ", reference='" + "'" + ", city='" + getCity() + "'" + ", state='" + getState() + "'" + "'" + "}";
    }

}