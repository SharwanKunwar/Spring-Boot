package com.unpredictableXfilters.FilterSeriesV01.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("api_key");

        // Validate token
        if (token == null || !token.equals("143"))
        {
            sendUnauthorizedResponse(
                    httpServletResponse,
                    "Invalid or missing token!"
            );
            return;
        }

        // Validate API key
        if (apiKey == null || !apiKey.equals("hell"))
        {
            sendUnauthorizedResponse(
                    httpServletResponse,
                    "Invalid or missing API key!"
            );
            return;
        }

        // Both token and API key are valid

        chain.doFilter(httpServletRequest, httpServletResponse);

    }

    private void sendUnauthorizedResponse(HttpServletResponse response, String message) throws IOException
    {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"status\": 401,\n" +
                        "    \"message\": \"" + message + "\"\n" +
                        "}"
        );
    }



}
