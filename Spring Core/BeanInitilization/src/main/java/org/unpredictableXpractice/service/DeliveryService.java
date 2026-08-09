package org.unpredictableXpractice.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DeliveryService
{
    public  DeliveryService()
    {
        System.out.println("DeliveryService created");
    }
}
