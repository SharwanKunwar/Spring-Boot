package com.unpredictableXpractice.DemoNotificationSystem;

import com.unpredictableXpractice.DemoNotificationSystem.notification.EmailService;
import com.unpredictableXpractice.DemoNotificationSystem.notification.NotificationServiceHelper;
import com.unpredictableXpractice.DemoNotificationSystem.notification.PopUpNotificationService;
import com.unpredictableXpractice.DemoNotificationSystem.notification.SmsService;
import com.unpredictableXpractice.DemoNotificationSystem.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import javax.management.Notification;

@SpringBootApplication
public class DemoNotificationSystemApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoNotificationSystemApplication.class, args);
		NotificationServiceHelper n = new EmailService();
		OrderService orderService = new OrderService(n);
		orderService.placeOrder("Monitor");
	}

}
