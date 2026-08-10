package org.unpredictableXpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.unpredictableXpractice.awareInterface.Mahakal;
import org.unpredictableXpractice.config.AppConfig;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mahakal mahakal = context.getBean(Mahakal.class);
    }
}
