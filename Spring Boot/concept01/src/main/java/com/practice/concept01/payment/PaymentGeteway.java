package com.practice.concept01.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGeteway
{

    @Value("${PaymentGateway.type}")
    private String type;
    @Value("${PaymentGateway.retryCount}")
    private int retryCount;

//    public PaymentGeteway(@Value("${PaymentGateway.type}") String type, @Value("${PaymentGateway.retryCount}") int retryCount)
//    {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

}


/*
- property injection
- constructor injection

- @Value("${PaymentGateway.type:khalti}") default if defined not found.
 */