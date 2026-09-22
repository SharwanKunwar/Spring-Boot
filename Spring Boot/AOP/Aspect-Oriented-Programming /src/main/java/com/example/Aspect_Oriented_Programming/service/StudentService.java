package com.example.Aspect_Oriented_Programming.service;

import com.example.Aspect_Oriented_Programming.dtos.StudentRequestDTO;
import com.example.Aspect_Oriented_Programming.service.handler.StudentServiceHandler;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceHandler
{
    @Override
    public void createStudent(StudentRequestDTO requestDTO)
    {
        // let's suppose create student method takes 2 ms to complete this process
        try {
            Thread.sleep(2000);
        }catch (Exception ex){

        }
        System.out.println("Student is created.");
    }
}
