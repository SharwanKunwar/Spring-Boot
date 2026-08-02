package org.unpredictableXpractice.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService
{
    public OrderService(){
        System.out.println("Order service constructure created.");
    }
    public void placeOrder(){
        System.out.println("Order placed.");
    }
}
