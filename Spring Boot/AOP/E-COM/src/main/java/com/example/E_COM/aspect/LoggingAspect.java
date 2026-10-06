package com.example.E_COM.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect
{

    // this @Before can only read it doesn't have write/override capability
    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("Product is going to be saved.");
        Object[] args = joinPoint.getArgs();
        System.out.println("args is " + Arrays.toString(args));
        boolean valid = false;

        if(!valid){
            throw new RuntimeException("method execution not allowed");
        }

    }
}
