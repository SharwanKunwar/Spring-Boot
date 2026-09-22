package com.unpredictableXMovies.MovieHub.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        long start = System.currentTimeMillis();

        String token = httpServletRequest.getHeader("token");

        System.out.println("--- --- --- --- Entered Logging Filter --- --- --- ---");
        System.out.println("token : "+ token);
        chain.doFilter(request, response);

        System.out.println("Response time : "+ (System.currentTimeMillis() - start) + " ms");
        System.out.println("--- --- --- --- Entered Logging Filter --- --- --- ---");
        System.out.println("------------------------------------------------------");

    }
}
