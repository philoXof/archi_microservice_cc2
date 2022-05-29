package com.example.archi_microservice_cc2.domain;


public interface PaymentDAO {

    void savePayment(Payment payment, PaymentStatus status);

    boolean exist(String checkoutId);
    PaymentStatus getByCheckoutId(String checkoutId);
    void update(Payment payment, PaymentStatus status);
    void delete(String id);
}
