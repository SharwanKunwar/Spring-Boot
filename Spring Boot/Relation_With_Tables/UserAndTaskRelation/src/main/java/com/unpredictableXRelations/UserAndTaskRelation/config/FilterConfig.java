package com.unpredictableXRelations.UserAndTaskRelation.config;


import com.unpredictableXRelations.UserAndTaskRelation.filter.TaskFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig
{
    @Bean
    public FilterRegistrationBean<TaskFilter> getTaskFilter()
    {
        FilterRegistrationBean<TaskFilter> taskFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        taskFilterFilterRegistrationBean.setFilter(new TaskFilter());
        taskFilterFilterRegistrationBean.addUrlPatterns("/api/tasks/*"); // ("/api/tasks/*, /api/users/*") you can add multiple patterns
        return taskFilterFilterRegistrationBean;
    }

}
