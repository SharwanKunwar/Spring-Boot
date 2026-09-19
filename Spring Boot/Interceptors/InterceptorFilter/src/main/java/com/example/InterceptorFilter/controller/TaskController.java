package com.example.InterceptorFilter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController
{
    @PostMapping
    public ResponseEntity<String> createTask(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Task is created.");
    }
}
