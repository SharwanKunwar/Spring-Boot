package org.unpredictableXpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.unpredictableXpractice.config.AppConfig;
import org.unpredictableXpractice.service.OrderService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order01 = context.getBean(OrderService.class);
        OrderService order02 = context.getBean(OrderService.class);

        if(order01 == order02) System.out.println("same object coz : look above there is one constructor right. so this is singleton scope");

    }
}
