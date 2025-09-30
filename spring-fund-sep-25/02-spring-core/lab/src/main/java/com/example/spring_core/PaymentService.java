package com.example.spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private UserService userservice;

    @Autowired
    public PaymentService(UserService userservice) {
        this.userservice = userservice;
    }

    public void processPayment() {
        System.out.println("Chargin user - " + userservice.getUser());
    }
}
