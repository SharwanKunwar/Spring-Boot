package org.unpredictableXpractice.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotificationService implements  NotificationServiceHelper
{

    @Override
    public String sendNotification() {
        return "Email";
    }
}
