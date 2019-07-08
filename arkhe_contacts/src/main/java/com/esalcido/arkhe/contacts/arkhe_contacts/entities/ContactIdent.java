package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ContactIdent
 */
@Entity
@Table(name = "TABLE_CONTACT_IDENT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ContactIdent implements Serializable {

    @Id
    @Column(name = "DOCUMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;
    @Column(name = "DOCUMENT_NAME")
    private String documentName;
    // @OneToOne(mappedBy = "documentType")
    // private Contact contact;

    public ContactIdent() {

    }

    public ContactIdent(int documentId, String documentName) {
        this.documentId = documentId;
        this.documentName = documentName;
    }

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public String toString() {
        return "ContactIdent [documentId=" + documentId + ", documentName=" + documentName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + documentId;
        result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContactIdent other = (ContactIdent) obj;
        if (documentId != other.documentId)
            return false;
        if (documentName == null) {
            if (other.documentName != null)
                return false;
        } else if (!documentName.equals(other.documentName))
            return false;
        return true;
    }

}