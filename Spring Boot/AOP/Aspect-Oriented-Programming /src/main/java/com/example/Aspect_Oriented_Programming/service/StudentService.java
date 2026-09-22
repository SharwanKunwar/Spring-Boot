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
        System.out.println("Student is created.");
    }
}
