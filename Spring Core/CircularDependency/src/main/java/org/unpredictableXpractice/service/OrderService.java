package org.unpredictableXpractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.payment.PaymentService;

@Component
public class OrderService
{
    @Autowired
    private PaymentService payment;


//    public OrderService(PaymentService payment)
//    {
//        this.payment = payment;
//    }

    public void placeOrder(){
        System.out.println("Order placed.");
        payment.pay();
    }

    public void getOrderDetails(){
        System.out.println("Order details.");
    }
}
