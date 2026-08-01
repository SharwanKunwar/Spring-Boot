package org.unpredictableXpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.notification.NotificationServiceHelper;
import org.unpredictableXpractice.payment.PaymentServiceHelper;

@Component
public class OrderService
{
    PaymentServiceHelper payment;
    NotificationServiceHelper notification;


    @Autowired
    public OrderService(@Qualifier("Stripe") PaymentServiceHelper payment, @Qualifier("SMS") NotificationServiceHelper notification){
        this.payment = payment;
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Placing order...");
        System.out.println("Payed by "+payment.pay());
        System.out.println("Sent notification via "+notification.sendNotification());
    }
}
