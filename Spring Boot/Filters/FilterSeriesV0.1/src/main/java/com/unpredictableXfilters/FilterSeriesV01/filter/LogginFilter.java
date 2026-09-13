package com.unpredictableXfilters.FilterSeriesV01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class LogginFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {

        System.out.println("Hi\n");

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        System.out.println("-------------- Incoming Request --------------");
        System.out.println("Method: "+servletRequest.getMethod());
        System.out.println("RequestURI: "+servletRequest.getRequestURI());



        chain.doFilter(request, response);

        System.out.println("\n\n-------------- Outgoing Response --------------");
        System.out.println("Status: "+servletResponse.getStatus());




        System.out.println("\nBye");

    }
}
