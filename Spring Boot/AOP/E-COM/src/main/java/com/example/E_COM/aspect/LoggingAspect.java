package com.example.E_COM.aspect;

import com.example.E_COM.dtos.ProductResponseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    // 5. @Around
    @Around("execution(* com.example.E_COM.service.implementation.ProductService.createProduct(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("========== @Around - BEFORE ==========");

        long start = System.currentTimeMillis();

        // Actual method execution
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("========== @Around - AFTER ==========");

        System.out.println("Execution time: "
                + (end - start) + " ms");

        System.out.println("Result: " + result);

        return result;
    }

}



/**
 * This class demonstrates the different types of Spring AOP Advices.
 *
 * In this class, our main focus is on understanding how different Advices work,
 * rather than focusing on Pointcuts.
 *
 * We use the same Pointcut expression for the ProductService.createProduct(..)
 * method and apply different types of Advice:
 *
 * 1. @Before          -> Executes before the target method.
 * 2. @AfterReturning  -> Executes after the method successfully returns.
 * 3. @AfterThrowing   -> Executes when the method throws an exception.
 * 4. @After           -> Executes after the method finishes, whether it succeeds or fails.
 * 5. @Around          -> Gives complete control over the method execution
 *                        and can execute code before and after the method.
 *
 * The purpose of this class is to understand the lifecycle and behavior
 * of each type of Advice in Spring AOP.
 *
 * Note:
 * Pointcut expressions are kept simple and mostly the same throughout this class
 * because the primary focus here is on understanding Advices.
 */