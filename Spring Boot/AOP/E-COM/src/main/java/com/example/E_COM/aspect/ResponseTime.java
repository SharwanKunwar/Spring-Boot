package com.example.E_COM.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResponseTime
{
    @Around("execution(* com.example.E_COM.service..*(..))")
    public Object calculateResponseTime1(ProceedingJoinPoint joinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();

        // Execute the actual service method
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + executionTime + " ms"
        );

        return result;
    }

    @Around("within(com.example.E_COM.service..*)")
    public Object calculateResponseTime2(ProceedingJoinPoint joinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + executionTime + " ms"
        );

        return result;
    }

    @Around("@annotation(com.example.E_COM.aspect.customAnnotation.ResponseTracker)")
    public Object calculateResponseTime3(ProceedingJoinPoint joinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + executionTime + " ms"
        );

        return result;
    }

    @Around("bean(productService)")
    public Object calculateResponseTime4(ProceedingJoinPoint joinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + executionTime + " ms"
        );

        return result;
    }

    @Around("bean(productService) || bean(productController")  // any logical operator : & || ! ... even single like bean(productService)
    public Object calculateResponseTimeDemoJoin(ProceedingJoinPoint joinPoint) throws Throwable
    {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionTime = endTime - startTime;

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + executionTime + " ms"
        );

        return result;
    }

}


/**
 * This class demonstrates how Pointcuts and Advices work together in Spring AOP.
 *
 * In the previous LoggingAspect class, our main focus was on understanding
 * different types of Advices such as @Before, @After, @AfterReturning,
 * @AfterThrowing, and @Around.
 *
 * In this class, our focus is on both:
 *
 * 1. Pointcuts -> Define WHERE the Aspect should be applied.
 * 2. Advices  -> Define WHAT should happen when the Pointcut is matched.
 *
 * The main purpose of this Aspect is to measure the response/execution time
 * of selected methods.
 *
 * We will define Pointcuts to select the required methods and use Advice
 * (mainly @Around) to calculate how much time those methods take to execute.
 *
 * In short:
 *
 * Pointcut -> WHERE should the Aspect work?
 * Advice   -> WHAT should the Aspect do?
 *
 * Example:
 * Pointcut: Select ProductService methods.
 * Advice:   Calculate and log their execution time.
 */