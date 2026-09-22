package com.example.Aspect_Oriented_Programming.controller;

import com.example.Aspect_Oriented_Programming.dtos.StudentRequestDTO;
import com.example.Aspect_Oriented_Programming.service.handler.StudentServiceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController
{

    private final StudentServiceHandler service;

    public StudentController(StudentServiceHandler studentServiceHandler){
        this.service = studentServiceHandler;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody StudentRequestDTO requestDTO)
    {
        service.createStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("DONE.");
    }

}
