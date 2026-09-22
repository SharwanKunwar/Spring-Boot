package com.unpredictableXMovies.MovieHub.config;

import com.unpredictableXMovies.MovieHub.interceptors.LoggingInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;

@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer
{

    private final LoggingInterceptor loggingInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }

    // This is for interceptors
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**");
    }
}