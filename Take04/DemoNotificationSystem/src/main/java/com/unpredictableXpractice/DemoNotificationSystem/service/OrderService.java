package com.unpredictableXpractice.DemoNotificationSystem.service;

import com.unpredictableXpractice.DemoNotificationSystem.notification.EmailService;
import com.unpredictableXpractice.DemoNotificationSystem.notification.NotificationServiceHelper;

public class OrderService
{
    public void placeOrder(NotificationServiceHelper n) {
        System.out.println("Placing order...");
        n.sendNotification();

    }
}
