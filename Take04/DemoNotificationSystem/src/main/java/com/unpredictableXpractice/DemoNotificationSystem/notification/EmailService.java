package com.unpredictableXpractice.DemoNotificationSystem.notification;

public class EmailService implements NotificationServiceHelper
{
    @Override
    public void sendNotification() {
        System.out.println("Email notification sent");
    }
}
