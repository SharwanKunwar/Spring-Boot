package com.practice.concept01.AutoConfiguredUsingAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User
{
    private UserProperties userProperties;

    public User(UserProperties userProperties){
        this.userProperties = userProperties;
    }

    public String getName(){
        return userProperties.getName();
    }
    public int getAge(){
        return userProperties.getAge();
    }

}
