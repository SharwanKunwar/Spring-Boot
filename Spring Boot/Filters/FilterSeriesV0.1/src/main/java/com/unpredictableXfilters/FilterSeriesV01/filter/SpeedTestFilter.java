package com.unpredictableXfilters.FilterSeriesV01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class SpeedTestFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {

        Long start = System.currentTimeMillis();

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        try {
            chain.doFilter(servletRequest, servletResponse);
        }finally {
            Long duration = System.currentTimeMillis() - start;
            System.out.println("Response Speed : "+duration+" M/s");
        }

    }
}
