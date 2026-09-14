package com.unpredictableXfilters.FilterSeriesV01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;


//@Component
public class LogginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        Long start = System.currentTimeMillis();

        System.out.println("Hi\n");

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        System.out.println("-------------- Incoming Request --------------");
        System.out.println("Method: "+servletRequest.getMethod());
        System.out.println("RequestURI: "+servletRequest.getRequestURI());

        String id = UUID.randomUUID().toString();
        servletResponse.setHeader("Request-ID",id);


        try {
            chain.doFilter(request, response);
        }finally {
            Long duration = System.currentTimeMillis() - start;
            System.out.println("\n\n-------------- Outgoing Response --------------");
            System.out.println("Response ID : "+id);
            System.out.println("Status: "+servletResponse.getStatus());
            System.out.println("Product is created");
            System.out.println("Response Speed : "+duration+" M/s");
        }



        System.out.println("\nBye");

    }
}
