package com.example.InterceptorFilter.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        System.out.println("--------------------------------------------- Pre Handler scope -----");

        // we are checking that handler is Handler type or not if yes we do else -> else
        if(handler instanceof HandlerMethod handlerMethod)
        {
            String controllerName = handlerMethod.getBeanType().getName();
            String methodName = handlerMethod.getMethod().getName();
            System.out.println("Controller : "+controllerName);
            System.out.println("Method : "+methodName);
        }


        System.out.println("--------------------------------------------------------\n");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    {
        System.out.println("--------------------------------------------- Post Handler scope -----");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
        System.out.println("--------------------------------------------- After Completion Handler scope -----");
    }
}
