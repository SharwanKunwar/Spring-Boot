package com.example.InterceptorFilter.config;

import com.example.InterceptorFilter.interceptor.AuthenticationInterceptor;
import com.example.InterceptorFilter.interceptor.AuthorizationInterceptor;
import com.example.InterceptorFilter.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    private final LoginInterceptor loginInterceptor;
    private final AuthenticationInterceptor authenticationInterceptor;
    private final AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor, AuthenticationInterceptor authenticationInterceptor, AuthorizationInterceptor authorizationInterceptor)
    {
        this.loginInterceptor = loginInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 1. Logging: runs first so every request is recorded, even ones rejected later
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .order(1);

        // 2. Authentication: who are you? (skip public endpoints)
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/policy/**", "/api/public/**")
                .order(2);

        // 3. Authorization: are you allowed? Needs the identity from step 2
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/policy/**", "/api/public/**")
                .order(3);
    }
}