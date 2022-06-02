package com.example.archi_microservice_cc2;

import com.example.archi_microservice_cc2.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RedisOperationsRunner implements CommandLineRunner {

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public void run(String... args) throws Exception {

        var creditCard = new CreditCard("1234567890", "123", "Kélyan");
        var buyer = new Buyer("1", "Kélyan", "BERVIN", creditCard);


        paymentDAO.savePayment(new Payment(buyer, "1", 12.3), PaymentStatus.DONE);

        paymentDAO.update(new Payment(buyer, "1", 28.5), PaymentStatus.DONE);

        paymentDAO.delete("1");

    }
}
