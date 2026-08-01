package org.unpredictableXpractice.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentService
{
    public boolean pay(){
        System.out.println("Payment done.");
        return true;
    }
}
