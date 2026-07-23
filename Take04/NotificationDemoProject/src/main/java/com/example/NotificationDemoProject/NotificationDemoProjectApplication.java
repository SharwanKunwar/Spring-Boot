package com.example.NotificationDemoProject;

import com.example.NotificationDemoProject.notification.EmailService;
import com.example.NotificationDemoProject.notification.NotificationService;
import com.example.NotificationDemoProject.serivice.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationDemoProjectApplication {

	public static void main(String[] args)
	{

		SpringApplication.run(NotificationDemoProjectApplication.class, args);
		NotificationService n = new EmailService();
		OrderService order =  new OrderService(n);
		order.placeOrder();

	}

}
