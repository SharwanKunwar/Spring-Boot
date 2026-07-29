package org.unpredictableXpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.notification.NotificationServiceHelper;
import org.unpredictableXpractice.payment.PaymentServiceHelper;

@Component
public class BookingService
{
    private final PaymentServiceHelper payment;
    private final NotificationServiceHelper notification;

    @Autowired
    public BookingService(PaymentServiceHelper payment,  NotificationServiceHelper notification)
    {
        this.payment = payment;
        this.notification = notification;
    }

    public void bookRoom(){
        System.out.println("Booking Room");
        System.out.println("Payed by "+payment.pay());
        System.out.println("Notification sent via "+notification.sendNotification());
    }
}
