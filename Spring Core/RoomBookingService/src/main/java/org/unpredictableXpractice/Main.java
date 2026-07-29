package org.unpredictableXpractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.unpredictableXpractice.config.AppConfig;
import org.unpredictableXpractice.service.BookingService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BookingService booking = context.getBean(BookingService.class);
        booking.bookRoom();

    }
}
