package com.example.E_COM.aspect.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts
{
    @Pointcut("within(com.example.E_COM.controller..*(..))) && execution(public * * (..))")
    public void controllerLayer(){
        //empty body
    }

    @Pointcut("within(com.example.E_COM.service..*(..))) && execution(public * * (..))")
    public void serviceLayer(){
        //empty body
    }

}
