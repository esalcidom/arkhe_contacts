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
 * TaxRef
 */
@Entity
@Table(name = "TABLE_TAX_REG")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TaxRef{

    @Id
    @Column(name = "TAX_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxID;
    @NotNull
    @Size(min=1, max=20, message="Tax Reg type should be between 1 and 20 characters long")
    @Column(name = "TAX_NAME")
    private String taxName;

    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public TaxRef(int taxID, String taxName) {
        this.taxID = taxID;
        this.taxName = taxName;
    }

    public TaxRef() {

    }

    @Override
    public String toString() {
        return "TaxRef [taxID=" + taxID + ", taxName=" + taxName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxID, taxName);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaxRef)) {
            return false;
        }
        TaxRef taxRef = (TaxRef) o;
        return taxID == taxRef.taxID && Objects.equals(taxName, taxRef.taxName);
    }
}