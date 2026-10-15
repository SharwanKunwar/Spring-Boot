package com.example.CustomAnnoatationWithAspect.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect
{
//    @Before("execution(* com.example.CustomAnnoatationWithAspect.service.implementation..*(..))")
//    public void logBefore()
//    {
//        System.out.println("interception.");
//    }
}
