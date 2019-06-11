package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Contact
 */
@Entity
@Table(name="TABLE_CONTACT")
public class Contact {

    @Id
    @Column(name="CONTACT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contactId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="OTHER_NAME")
    private String otherName;
    @Column(name="PHONE")
    private String phone;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ADDRESS_ID")
    private long addressId;
    @Column(name="BIRTHDATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date birthdate;
    @Column(name="GENDER")
    private int gender;
    @Column(name="TAX_REGIME")
    private int taxRegime;
    @Column(name="DOCUMENT_TYPE")
    private int documentType;
    @Column(name="DOCUMENT_NUMBER")
    private String documentNumber;
    @Column(name="LAST_UPDATE")
    private Date lastUpdate;

    public Contact() {
    }

    public Contact(long contactId, String firstName, String lastName, String otherName, String phone, String email, long addressId, Date birthdate, int gender, int taxRegime, int documentType, String documentNumber, Date lastUpdate) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.otherName = otherName;
        this.phone = phone;
        this.email = email;
        this.addressId = addressId;
        this.birthdate = birthdate;
        this.gender = gender;
        this.taxRegime = taxRegime;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.lastUpdate = lastUpdate;
    }

    public long getContactId() {
        return this.contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTaxRegime() {
        return this.taxRegime;
    }

    public void setTaxRegime(int taxRegime) {
        this.taxRegime = taxRegime;
    }

    public int getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Contact contactId(long contactId) {
        this.contactId = contactId;
        return this;
    }

    public Contact firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact otherName(String otherName) {
        this.otherName = otherName;
        return this;
    }

    public Contact phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact email(String email) {
        this.email = email;
        return this;
    }

    public Contact addressId(long addressId) {
        this.addressId = addressId;
        return this;
    }

    public Contact birthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Contact gender(int gender) {
        this.gender = gender;
        return this;
    }

    public Contact taxRegime(int taxRegime) {
        this.taxRegime = taxRegime;
        return this;
    }

    public Contact documentType(int documentType) {
        this.documentType = documentType;
        return this;
    }

    public Contact documentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public Contact lastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) o;
        return contactId == contact.contactId && Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(otherName, contact.otherName) && Objects.equals(phone, contact.phone) && Objects.equals(email, contact.email) && addressId == contact.addressId && Objects.equals(birthdate, contact.birthdate) && gender == contact.gender && taxRegime == contact.taxRegime && documentType == contact.documentType && Objects.equals(documentNumber, contact.documentNumber) && Objects.equals(lastUpdate, contact.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName, lastName, otherName, phone, email, addressId, birthdate, gender, taxRegime, documentType, documentNumber, lastUpdate);
    }

    @Override
    public String toString() {
        return "{" +
            " contactId='" + getContactId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", otherName='" + getOtherName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", addressId='" + getAddressId() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", gender='" + getGender() + "'" +
            ", taxRegime='" + getTaxRegime() + "'" +
            ", documentType='" + getDocumentType() + "'" +
            ", documentNumber='" + getDocumentNumber() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            "}";
    }

}