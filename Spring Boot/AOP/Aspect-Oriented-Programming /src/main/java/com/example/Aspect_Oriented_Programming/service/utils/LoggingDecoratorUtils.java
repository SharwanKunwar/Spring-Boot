package com.example.Aspect_Oriented_Programming.service.utils;

public class LoggingDecoratorUtils
{
    // Start
    public static void logStart(String className, String methodName){
        System.out.println("Executing --> ClassName : "+ className+" : "+ " MethodName : "+methodName);
    }

    // End
    public static void logEnd(String className, String methodName)
    {
        System.out.println("Finishing --> ClassName : "+ className+" : "+ " MethodName : "+methodName);
    }
}
