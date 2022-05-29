package com.example.archi_microservice_cc2.domain;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentValidationService {

    public boolean isValid(Payment payment){
        Random random = new Random();
        return random.nextBoolean();
    }
}
