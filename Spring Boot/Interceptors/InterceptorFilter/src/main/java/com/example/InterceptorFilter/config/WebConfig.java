package com.example.InterceptorFilter.config;

import com.example.InterceptorFilter.interceptor.AuthenticationInterceptor;
import com.example.InterceptorFilter.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    public LoginInterceptor loginInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor, AuthenticationInterceptor authenticationInterceptor)
    {
        this.loginInterceptor = loginInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/private/**");  // what we are saying not run authentication interceptor for this kinda url path
    }
}
