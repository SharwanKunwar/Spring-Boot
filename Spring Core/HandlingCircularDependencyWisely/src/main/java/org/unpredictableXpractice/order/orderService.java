package org.unpredictableXpractice.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.payment.PaymentService;

@Component
public class orderService
{
    private PaymentService payment;

    @Autowired
    public orderService(PaymentService payment)
    {
        this.payment = payment;
    }

    public void placeOrder()
    {
        System.out.println("Placing order...");
        if(payment.pay()) getOrderDetails();
        else System.out.println("Payment failed");
    }

    public void getOrderDetails(){
        System.out.println("Getting order details...");
    }
}
