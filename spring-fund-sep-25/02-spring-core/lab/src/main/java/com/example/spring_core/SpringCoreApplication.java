package com.example.spring_core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext appCtx = SpringApplication.run(SpringCoreApplication.class, args);

		UserService userservice = appCtx.getBean(UserService.class);
		UserService userservice2 = appCtx.getBean(UserService.class);
		UserService userservice3 = appCtx.getBean(UserService.class);
		UserService userservice4 = appCtx.getBean(UserService.class);
		UserService userservice5 = appCtx.getBean(UserService.class);
		PaymentService paymentservice = appCtx.getBean(PaymentService.class);

		paymentservice.processPayment();
		userservice.welcomeToUser();

		System.out.println("END");
	}

}
