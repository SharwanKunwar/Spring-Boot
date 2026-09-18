package com.unpredictableXRelations.UserAndTaskRelation.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

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
        // other things as well but there is a exception if we want we can but it's gets cold anyway.
    }
}
