package com.example.CustomAnnoatationWithAspect.aspect;

import com.example.CustomAnnoatationWithAspect.customAnnotations.Greeting;
import com.example.CustomAnnoatationWithAspect.customAnnotations.TrackResponseTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Component
@Aspect
public class LoggingAspect {

//    @Around("@annotation(com.example.CustomAnnoatationWithAspect.customAnnotations.TrackResponseTime)")
//    public Object trackResponseTime(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long startTime = System.currentTimeMillis();
//        System.out.println("interception started.");
//
//        Object result = joinPoint.proceed(); // Executes the target method
//
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("Method: " + joinPoint.getSignature().getName() + " | Execution Time: " + (endTime - startTime) + " ms");
//
//        return result;
//    }

//    @Around("@annotation(com.example.CustomAnnoatationWithAspect.customAnnotations.Greeting)")
//    public Object greet(ProceedingJoinPoint joinPoint) throws Throwable
//    {
//        System.out.println("Hi i'm intercepting '"+joinPoint.getSignature().getName()+"'");
//        Object result = joinPoint.proceed(); // Executes the target method
//        System.out.println("Bye i'm done intercepting '"+joinPoint.getSignature().getName()+"'");
//        return result;
//    }


    //Binding form
    @Around("@annotation(greeting)")
    public Object greet(ProceedingJoinPoint joinPoint, Greeting greeting) throws Throwable
    {
        System.out.println("Hi i'm intercepting '"+joinPoint.getSignature().getName()+"'");
        Object result = joinPoint.proceed(); // Executes the target method
        String operation = greeting.operation();
        if(operation.isBlank()) operation = joinPoint.getSignature().getName();
        System.out.println("Operation: " + operation);
        System.out.println("Bye i'm done intercepting "+operation);

        return result;
    }

    @Around("@annotation(trackResponseTime)")
    public Object trackResponseTime1(ProceedingJoinPoint joinPoint, TrackResponseTime trackResponseTime) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("interception started.");

        Object result = joinPoint.proceed(); // Executes the target method

        long endTime = System.currentTimeMillis();
        String operation = trackResponseTime.operation();
        if(operation.isBlank()) operation = joinPoint.getSignature().getName();

        System.out.println("Method: " + operation + " | Execution Time: " + (endTime - startTime) + " ms");
        if((endTime-startTime)>trackResponseTime.warnAfter()){
            System.out.println("slow");
        }else {
            System.out.println("ok");
        }

        return result;
    }
}