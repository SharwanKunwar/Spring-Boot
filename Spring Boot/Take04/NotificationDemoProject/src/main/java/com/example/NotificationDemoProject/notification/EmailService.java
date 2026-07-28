package com.example.NotificationDemoProject.notification;

public class EmailService implements NotificationService {
    @Override
    public String sendNotification() {
        return "Email";
    }
}
