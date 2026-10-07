package com.example.E_COM.aspect;

import com.example.E_COM.dtos.ProductResponseDTO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{

    // this @Before can only read it doesn't have write/override capability
//    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
//    public void logBefore(JoinPoint joinPoint)
//    {
//        System.out.println("Product is going to be saved.");
//        Object[] args = joinPoint.getArgs();
//        System.out.println(args[0]);
//        boolean valid = true;
//
//        if(!valid){
//            throw new RuntimeException("method execution not allowed");
//        }
//
//    }

    @AfterReturning(value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))", returning = "res")
    public void logAfterReturning(ProductResponseDTO res){
        res.setName("phone");        // don't do these kind of things in afterREturning. this work is good to be in around.
        System.out.println("Target method : "+ res);
    }
}
