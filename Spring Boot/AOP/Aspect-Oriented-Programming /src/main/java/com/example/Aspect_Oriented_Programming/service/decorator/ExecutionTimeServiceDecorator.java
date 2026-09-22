package com.example.Aspect_Oriented_Programming.service.decorator;

import com.example.Aspect_Oriented_Programming.dtos.StudentRequestDTO;
import com.example.Aspect_Oriented_Programming.service.handler.StudentServiceHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeServiceDecorator implements StudentServiceHandler
{
    private final LoggingDecorator loggingDecorator;

    public ExecutionTimeServiceDecorator(LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator;
    }


    @Override
    public void createStudent(StudentRequestDTO requestDTO)
    {
        long start = System.currentTimeMillis();
        loggingDecorator.createStudent(requestDTO);
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Execution duration is : "+duration+" ms");
    }
}
