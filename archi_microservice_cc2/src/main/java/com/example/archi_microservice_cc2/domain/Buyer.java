package com.example.archi_microservice_cc2.domain;

import java.io.Serializable;

public class Buyer implements Serializable {
    String id;
    String firstname;
    String lastname;
    CreditCard creditCard;

    public Buyer(String id, String firstname, String lastname, CreditCard creditCard) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.creditCard = creditCard;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
