package com.example.CustomAnnoatationWithAspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("@annotation(com.example.CustomAnnoatationWithAspect.customAnnotations.TrackResponseTime)")
    public Object trackResponseTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("interception started.");

        Object result = joinPoint.proceed(); // Executes the target method

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution Time: " + (endTime - startTime) + " ms"
        );

        return result;
    }

    @Around("@annotation(com.example.CustomAnnoatationWithAspect.customAnnotations.Greeting)")
    public void greet(ProceedingJoinPoint joinPoint) throws Throwable
    {
        System.out.println("Hi");
        Object result = joinPoint.proceed(); // Executes the target method
        System.out.println("Bye");
    }
}