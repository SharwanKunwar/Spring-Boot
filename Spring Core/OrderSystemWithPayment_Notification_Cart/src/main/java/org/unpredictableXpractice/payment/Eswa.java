package org.unpredictableXpractice.payment;

import org.springframework.stereotype.Component;

@Component
public class Eswa implements PaymentServiceHelper
{
    @Override
    public String pay() {
        return "Eswa";
    }
}
