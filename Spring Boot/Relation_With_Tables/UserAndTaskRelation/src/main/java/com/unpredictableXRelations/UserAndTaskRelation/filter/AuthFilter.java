package com.unpredictableXRelations.UserAndTaskRelation.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        if(token == null || !token.equals("123"))
        {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"status\":\"401\",\n"+
                            "    \"message\": \"You are wrong here!!\"\n" +
                            "}"
            );
            return;
        }

        chain.doFilter(request, response);

    }
}
