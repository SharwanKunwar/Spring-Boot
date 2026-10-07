package com.example.E_COM.aspect;

import com.example.E_COM.dtos.ProductResponseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{

    // this @Before can only read it doesn't have write/override capability
    @Before("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("========== @Before ==========");
        System.out.println("Product is going to be saved.");

        Object[] args = joinPoint.getArgs();

        for (Object arg : args)
        {
            System.out.println("Argument: " + arg);
        }
    }

    // 2. @AfterReturning
    @AfterReturning(value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))", returning = "res")
    public void logAfterReturning(ProductResponseDTO res)
    {
        System.out.println("========== @AfterReturning ==========");
        System.out.println("Product created successfully.");
        System.out.println("Response: " + res);
    }

    // 3. @AfterThrowing
    @AfterThrowing(value = "execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex)
    {
        System.out.println("========== @AfterThrowing ==========");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + ex.getMessage());
    }

    // 4. @After
    @After("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("========== @After ==========");
        System.out.println("Method finished: "
                + joinPoint.getSignature().getName());
    }
}
