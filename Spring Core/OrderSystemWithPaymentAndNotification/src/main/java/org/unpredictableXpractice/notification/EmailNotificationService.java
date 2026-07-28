package org.unpredictableXpractice.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Email")
public class EmailNotificationService implements NotificationServiceHelper
{
    @Override
    public String sendNotification() {
        return "Email";
    }
}
