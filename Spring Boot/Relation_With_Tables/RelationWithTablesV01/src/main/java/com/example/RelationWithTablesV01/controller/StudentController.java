package com.example.RelationWithTablesV01.controller;

import com.example.RelationWithTablesV01.dtos.StudentRequestDTO;
import com.example.RelationWithTablesV01.dtos.StudentResponseDTO;
import com.example.RelationWithTablesV01.service.StudentServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentServiceHelper service;

    //Create
    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(requestDTO));
    }


    //Get all
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll()
    {
        return ResponseEntity.ok(service.getAllStudent());
    }
}
