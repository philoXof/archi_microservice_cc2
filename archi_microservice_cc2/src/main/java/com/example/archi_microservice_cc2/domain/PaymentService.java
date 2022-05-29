package com.example.archi_microservice_cc2.domain;


import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void payment(String checkout_id){
        System.out.println("Paiement effectué");
    }
}
