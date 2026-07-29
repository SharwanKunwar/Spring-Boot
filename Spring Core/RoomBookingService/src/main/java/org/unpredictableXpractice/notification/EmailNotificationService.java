package org.unpredictableXpractice.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements  NotificationServiceHelper{
    @Override
    public String sendNotification() {
        return "Email";
    }
}
