package com.example.archi_microservice_cc2.domain;

public class CreditCard {
    String number;
    String cryptogram;
    String owner;

    public CreditCard(String number, String cryptogram, String owner) {
        this.number = number;
        this.cryptogram = cryptogram;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
