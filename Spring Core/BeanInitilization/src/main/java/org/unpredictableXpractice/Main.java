package org.unpredictableXpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unpredictableXpractice.config.AppConfig;
import org.unpredictableXpractice.service.DeliveryService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DeliveryService deliveryService = (DeliveryService) context.getBean("deliveryService");

    }
}
