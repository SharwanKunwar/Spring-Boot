package com.example.Aspect_Oriented_Programming.service.decorator;

import com.example.Aspect_Oriented_Programming.dtos.StudentRequestDTO;
import com.example.Aspect_Oriented_Programming.service.StudentService;
import com.example.Aspect_Oriented_Programming.service.handler.StudentServiceHandler;
import com.example.Aspect_Oriented_Programming.service.utils.LoggingDecoratorUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentServiceHandler
{
    private final StudentService service;

    public LoggingDecorator(StudentService studentService){
        this.service = studentService;
    }

    @Override
    public void createStudent(StudentRequestDTO requestDTO)
    {
        LoggingDecoratorUtils.logStart("StudentService", "createStudent()");
        service.createStudent(requestDTO);
        LoggingDecoratorUtils.logEnd("StudentService", "createStudent()");
    }
}
