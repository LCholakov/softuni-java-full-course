package com.example.spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    public UserService userservice;
    public void makeOrder(){

    }
}
