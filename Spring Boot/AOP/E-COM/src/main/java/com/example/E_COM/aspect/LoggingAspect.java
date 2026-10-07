package com.example.E_COM.aspect;

import com.example.E_COM.dtos.ProductResponseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{

    // this @Before can only read it doesn't have write/override capability
    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("========== @Before ==========");
        System.out.println("Product is going to be saved.");

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println("Argument: " + arg);
        }
    }

//    @AfterReturning(value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))", returning = "res")
//    public void logAfterReturning(ProductResponseDTO res){
//        res.setName("phone");        // don't do these kind of things in afterREturning. this work is good to be in around.
//        System.out.println("Target method : "+ res);
//    }
}
