package org.unpredictableXpractice.order;

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
    public OrderService(@Qualifier("Eswa") PaymentServiceHelper payment, @Qualifier("SMS") NotificationServiceHelper notification) {
        this.payment = payment;
        this.notification = notification;
    }
    public void placeOrder(){
        System.out.println("Placing order...");
        System.out.println("Payed by "+payment.pay());
        System.out.println("Notification sent via "+notification.sendNotification());
        System.out.println("Order placed.");
    }
}
