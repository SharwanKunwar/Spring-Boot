package org.unpredictableXpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.unpredictableXpractice.service.CartService;

@Configuration
@ComponentScan("org.unpredictableXpractice")
public class AppConfig
{
    @Bean
    public CartService cartService()
    {
        return new CartService();
    }
}
