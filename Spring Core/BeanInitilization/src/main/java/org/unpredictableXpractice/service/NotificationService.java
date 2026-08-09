package org.unpredictableXpractice.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class NotificationService
{
    public  NotificationService()
    {
        System.out.println("NotificationService created");
    }
}
