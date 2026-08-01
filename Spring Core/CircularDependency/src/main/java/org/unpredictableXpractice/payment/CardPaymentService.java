package org.unpredictableXpractice.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Card")
public class CardPaymentService implements  PaymentServiceHelper
{
    @Override
    public String pay()
    {
        return "Card Payment";
    }
}
