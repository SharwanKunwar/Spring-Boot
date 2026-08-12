package com.practice.concept01;

import com.practice.concept01.AutoConfiguredUsingAnnotation.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoRunner implements ApplicationRunner
{
    private User user;

    @Autowired
    public AutoRunner(User user)
    {
        this.user = user;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\n------------------------------------- Auto configured ---");
        user.display();
    }
}
