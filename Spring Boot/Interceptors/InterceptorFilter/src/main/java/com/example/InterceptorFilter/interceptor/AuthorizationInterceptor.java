package com.example.InterceptorFilter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("-------------------------------------------- Authorization Interceptor Pre Handler called ---");
        String role = request.getHeader("role");
        System.out.println(role+" is your role");

        if(role != null && !role.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                            "    \"message\": \"You are not authorize to perform this action\"\n" +
                            "}"
            );
        }
        return false;
    }
}
