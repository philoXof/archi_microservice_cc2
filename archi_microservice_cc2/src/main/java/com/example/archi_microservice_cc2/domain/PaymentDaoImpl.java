package com.example.archi_microservice_cc2.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentDaoImpl implements PaymentDAO {

    private final String hashReference = "Payment";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, PaymentStatus> hashOperations;


    @Override
    public void savePayment(Payment payment, PaymentStatus status) {
        hashOperations.putIfAbsent(hashReference, payment.getCheckout_id(), status);
    }

    @Override
    public boolean exist(String checkoutId) {
        var payment = hashOperations.keys(checkoutId);

        return !payment.isEmpty();
    }

    @Override
    public PaymentStatus getByCheckoutId(String checkoutId) {
        var paymentKey = hashOperations.keys(checkoutId);

        return hashOperations.get(checkoutId, paymentKey);
    }


    @Override
    public void update(Payment payment, PaymentStatus status) {
        hashOperations.put(hashReference, payment.getCheckout_id(), status);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(hashReference,id);
    }
}
