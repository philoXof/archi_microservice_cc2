package com.example.archi_microservice_cc2.domain;

import java.io.Serializable;

public class Payment implements Serializable {

    private Buyer buyer;
    private String checkout_id;
    private Double amount;

    public Payment(Buyer buyer, String checkout_id, Double amount) {
        this.buyer = buyer;
        this.checkout_id = checkout_id;
        this.amount = amount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public String getCheckout_id() {
        return checkout_id;
    }

    public Double getAmount() {
        return amount;
    }

}
