package com.example.E_COM.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResponseTimeAspect {



    // Measures execution time using the named pointcut
    @Around("logPublicServiceMethod()")
    public Object calculateResponseTime0(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Executes the target method
        long endTime = System.currentTimeMillis();

        // Logs the method name and execution time
        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");

        return result; // Returns the original method result
    }

    // Matches method executions in the service package and subpackages
    @Around("execution(* com.example.E_COM.service..*(..))")
    public Object calculateResponseTime1(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

    // Matches methods within classes in the service package and subpackages
    @Around("within(com.example.E_COM.service..*)")
    public Object calculateResponseTime2(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

    // Matches methods annotated with @ResponseTracker
    @Around("@annotation(com.example.E_COM.aspect.customAnnotation.ResponseTracker)")
    public Object calculateResponseTime3(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

    // Matches beans whose Spring bean name is productService
    @Around("bean(productService)")
    public Object calculateResponseTime4(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

    // Matches either productService or productController beans
    @Around("bean(productService) || bean(productController)")
    public Object calculateResponseTimeDemoJoin(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

    @Around("com.example.E_COM.aspect.pointcuts.controllerLayer()")
    public Object calculateResponseTime5(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName()
                + " | Execution Time: " + (endTime - startTime) + " ms");
        return result;
    }

}

/*
 * Pointcut = WHERE the aspect applies.
 * Advice   = WHAT the aspect does.
 * @Around  = Executes code before and after the target method.
 * proceed() = Executes the original method.
 * Purpose  = Measures and logs method execution time.
 */

