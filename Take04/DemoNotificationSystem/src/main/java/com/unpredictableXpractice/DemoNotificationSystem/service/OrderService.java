package com.unpredictableXpractice.DemoNotificationSystem.service;
import com.unpredictableXpractice.DemoNotificationSystem.notification.NotificationServiceHelper;

import java.util.Date;

public class OrderService
{
    NotificationServiceHelper notificationService;

    public OrderService(NotificationServiceHelper notificationService){
        this.notificationService = notificationService;
    }

    public void placeOrder(String item) throws InterruptedException
    {
        String methodName = notificationService.sendNotification();

        System.out.print("Wait for a sec .");
        int i=0;
        while(i!=3){
            Thread.sleep(1000);
            System.out.print(".");
            i++;
        }
        System.out.println("\n\ninfo about order: ");
        System.out.println("item: " + item);
        System.out.println("status: successfully placed");
        System.out.println("Date&Time: " + new Date());
        System.out.println("Notification method: "+methodName);
    }
}
