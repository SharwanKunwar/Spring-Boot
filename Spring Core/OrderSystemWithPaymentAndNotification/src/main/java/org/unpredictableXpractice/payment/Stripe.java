package org.unpredictableXpractice.payment;

import org.springframework.stereotype.Component;

@Component
public class Stripe implements PaymentServiceHelper
{
    @Override
    public String pay() {
        return "Stripe";
    }
}
