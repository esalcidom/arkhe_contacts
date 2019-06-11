package com.esalcido.arkhe.contacts.arkhe_contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LoginController
 */
@Controller
public class LoginController {

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }
    
}