package com.practice.concept01.AutoConfiguredUsingAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("user")
public class UserProperties
{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


// in here we are configuring all here removing work from user class : we fetch data from application.propertirs here and give to user or
// you can say dependency inject to user.