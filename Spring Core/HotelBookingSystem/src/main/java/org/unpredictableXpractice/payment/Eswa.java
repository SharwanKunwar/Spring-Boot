package org.unpredictableXpractice.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Eswa implements PaymentServiceHelper{
    @Override
    public String pay() {
        return "Eswa";
    }
}
