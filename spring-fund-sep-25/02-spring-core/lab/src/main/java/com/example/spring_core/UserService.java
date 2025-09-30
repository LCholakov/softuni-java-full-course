package com.example.spring_core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {

    @Value("${custom-user.name}")
    private String name;

    public void welcomeToUser() {
        System.out.println("Welcome to User Service " + name);
    }

    public String getUser() {
        return "Lyubo";
    }
}
