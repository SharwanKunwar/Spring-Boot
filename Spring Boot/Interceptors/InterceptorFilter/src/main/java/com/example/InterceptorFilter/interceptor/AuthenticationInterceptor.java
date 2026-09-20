package com.example.InterceptorFilter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor
{

    @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
   {
       System.out.println("Pre Handler called ----------------------------------------");
       String requestKey = request.getHeader("key");
       System.out.println(requestKey+" is your key");

       if(request != null && !requestKey.equals("777"))
       {
           response.setStatus(HttpServletResponse.SC_FORBIDDEN);
           response.getWriter().write(
                   "{\n" +
                           "    \"message\": \"You are not authorize to perform this action\"\n" +
                           "}"
           );
           return false;
       }

        return true;
    }
}
