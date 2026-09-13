package com.unpredictableXfilters.FilterSeriesV01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Primary
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("Hi you are in Auth Filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        String token = httpServletRequest.getHeader("token");
        if(token == null || !token.equals("143"))
        {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("Return where you come from and get your token correct first!!!");
            return;
        }

        if(token != null || token.equals("143"))
        {
            System.out.println("Your token is correct. you are good to go.\n");
            chain.doFilter(httpServletRequest, httpServletResponse);
        }


        System.out.println("Bye");

    }
}
