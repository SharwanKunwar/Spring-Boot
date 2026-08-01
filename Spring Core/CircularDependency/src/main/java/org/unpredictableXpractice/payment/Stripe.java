package org.unpredictableXpractice.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Stripe")
public class Stripe implements PaymentServiceHelper
{
    @Override
    public String pay()
    {
        return "Stripe payment";
    }
}
