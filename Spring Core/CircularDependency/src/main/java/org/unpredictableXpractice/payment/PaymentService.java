package org.unpredictableXpractice.payment;

import org.springframework.stereotype.Component;
import org.unpredictableXpractice.service.OrderService;

@Component
public class PaymentService
{
    OrderService order;

    public PaymentService(OrderService order)
    {
        this.order = order;
    }

    public void pay(){
        System.out.println("payment done");
        order.getOrderDetails();
    }
}
