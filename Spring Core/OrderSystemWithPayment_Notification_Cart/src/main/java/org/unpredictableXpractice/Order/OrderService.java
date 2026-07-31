package org.unpredictableXpractice.Order;

import org.springframework.stereotype.Component;
import org.unpredictableXpractice.notification.NotificationServiceHelper;
import org.unpredictableXpractice.payment.PaymentServiceHelper;
import org.unpredictableXpractice.service.CartService;

@Component
public class OrderService
{
    PaymentServiceHelper payment;
    NotificationServiceHelper notification;
    CartService cart;

    public OrderService(PaymentServiceHelper payment,  NotificationServiceHelper notification, CartService cart)
    {
        this.payment = payment;
        this.notification = notification;
        this.cart = cart;
    }

    public void placeOrder()
    {
        System.out.println("Placing order...");
        System.out.println("Payed by "+payment.pay());
        System.out.println("Notification is sent via "+notification.sendNotification());
        cart.addToCart();
        System.out.println("Order placed.");

    }
}
