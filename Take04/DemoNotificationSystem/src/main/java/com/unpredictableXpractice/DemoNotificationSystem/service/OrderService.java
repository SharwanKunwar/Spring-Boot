package com.unpredictableXpractice.DemoNotificationSystem.service;
import com.unpredictableXpractice.DemoNotificationSystem.notification.NotificationServiceHelper;

public class OrderService
{
    public void placeOrder(NotificationServiceHelper n) throws InterruptedException {
        System.out.print("Placing order.");
        int i=0;
        while(i!=3){
            Thread.sleep(1000);
            System.out.print(".");
            i++;
        }
        System.out.println("\n\nMessage: ");
        n.sendNotification();

    }
}
