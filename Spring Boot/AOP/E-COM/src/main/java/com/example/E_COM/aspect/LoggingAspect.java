package com.example.E_COM.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{

    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logBefore()
    {
        System.out.println("Product is going to be saved.");
        boolean valid = false;

        if(!valid){
            throw new RuntimeException("method execution not allowed");
        }

    }
}
