package com.esalcido.arkhe.contacts.arkhe_contacts.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ContactNotFoundException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String exception){
        super(exception);
    }
}