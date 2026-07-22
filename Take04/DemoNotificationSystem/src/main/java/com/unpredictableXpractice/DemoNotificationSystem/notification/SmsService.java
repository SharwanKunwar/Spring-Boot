package com.unpredictableXpractice.DemoNotificationSystem.notification;

public class SmsService implements NotificationServiceHelper
{
    @Override
    public void sendNotification() {
        System.out.println("sms notification sent");
    }
}
