package com.unpredictableXRelations.UserAndTaskRelation.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class RequestFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // getting header
        String holdToken = httpServletRequest.getHeader("token");

        // setting header
        // we don't wanna modify url header
        // other things as well but there is an exception if we want we can but it's gets cold anyway.

        BufferedReader reader = httpServletRequest.getReader();

        StringBuilder body = new StringBuilder();
        String line = reader.readLine();

        while(line != null)
        {
            body.append(line);
            line = reader.readLine();
        }
        System.out.println(body);
        System.out.println("hellllllllllll");

        chain.doFilter(request, response);

    }
}
