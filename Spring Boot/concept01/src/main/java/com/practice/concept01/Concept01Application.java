package com.practice.concept01;

import com.practice.concept01.AutoConfiguredUsingAnnotation.User;
import com.practice.concept01.payment.PaymentGeteway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Concept01Application {
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(Concept01Application.class, args);
		PaymentGeteway paymentGeteway = context.getBean(PaymentGeteway.class);
		User user = context.getBean(User.class);

		System.out.println("----------------------------------------manual---");
		System.out.println("Type : " + paymentGeteway.getType());
		System.out.println("Retry Count : " + paymentGeteway.getRetryCount());

		System.out.println("----------------------------------------Auto---");
		System.out.println("Name : " + user.getName());
		System.out.println("Age : " + user.getAge());


	}

}
