package com.example.archi_microservice_cc2.web.controller;


import com.example.archi_microservice_cc2.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.NonNull;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentValidationService paymentValidationService;
    private final PaymentService paymentService;
    private final PaymentDaoRedisImpl paymentDao;

    public PaymentController(PaymentValidationService paymentValidationService, PaymentService paymentService, PaymentDaoRedisImpl paymentDao) {
        this.paymentValidationService = paymentValidationService;
        this.paymentService = paymentService;
        this.paymentDao = paymentDao;
    }

    @PostMapping("/")
    public ResponseEntity<?> payment(@RequestBody @NonNull Payment payment){
        System.out.println("CheckoutId : " + payment.getCheckout_id());
        System.out.println("amount : " + payment.getAmount());
        System.out.println("buyer -> id : " + payment.getBuyer().getId());
        System.out.println("buyer -> firstname : " + payment.getBuyer().getFirstname());
        System.out.println("buyer -> lastname : " + payment.getBuyer().getLastname());
        System.out.println("Credit Card -> Number : " + payment.getBuyer().getCreditCard().getNumber());
        System.out.println("Credit Card -> Cryptogram : " + payment.getBuyer().getCreditCard().getCryptogram());
        System.out.println("Credit Card -> Owner : " + payment.getBuyer().getCreditCard().getOwner());

        if(!paymentDao.exist(payment.getCheckout_id()) || paymentDao.getByCheckoutId(payment.getCheckout_id()) == PaymentStatus.REFUSED){
            paymentDao.savePayment(payment, PaymentStatus.NONE);

            if(!paymentValidationService.isValid(payment)){
                paymentDao.update(payment, PaymentStatus.REFUSED);
                return new ResponseEntity<>("Paiement Refusé", HttpStatus.BAD_REQUEST);
            }
            paymentService.payment(payment.getCheckout_id());
            paymentDao.update(payment, PaymentStatus.DONE);
            return new ResponseEntity<>("Paiement accepté", HttpStatus.ACCEPTED);
        }
        //payment done || payment in progress
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
