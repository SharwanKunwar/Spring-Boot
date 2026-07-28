package com.example.NotificationDemoProject.serivice;

import com.example.NotificationDemoProject.notification.EmailService;
import com.example.NotificationDemoProject.notification.NotificationService;

public class OrderService
{
    NotificationService notification;

    public OrderService(NotificationService notification)
    {
        this.notification = notification;
    }

    public void placeOrder()
    {
        System.out.println("placing order");
        System.out.println("ordered placed : "+notification.sendNotification());
    }

}
