package org.unpredictableXpractice.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SMS")
public class SmsNotificationService implements NotificationServiceHelper
{
    @Override
    public String sendNotification() {
        return "SMS";
    }
}
