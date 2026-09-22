package com.unpredictableXMovies.MovieHub.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("\n\n------------------ Logging Interceptor (be specific)-------------------");

        String requestURI = request.getRequestURI();
        String quareyString = request.getQueryString();
        String clientIP = request.getRemoteAddr();
        String token = request.getHeader("token");


        System.out.println("------------------------ Request detail ---");
        System.out.println("Request URI : "+requestURI);
        System.out.println("Quarry string : "+quareyString);
        System.out.println("Client IP : "+clientIP);
        System.out.println("Token : "+token);

        // handler
        if(handler instanceof HandlerMethod handlerMethod)
        {
            String controllerName = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();

            System.out.println("Controller : " + controllerName);
            System.out.println("Method : " + methodName);
        }


        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView) throws Exception
    {
        System.out.println("\nExiting controler with these info : ");
        System.out.println(response.getStatus());
        System.out.println("----------- end of interceptor ----------------\n");
    }
}
