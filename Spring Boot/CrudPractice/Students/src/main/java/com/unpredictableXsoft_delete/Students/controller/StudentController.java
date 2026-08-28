package com.unpredictableXsoft_delete.Students.controller;

import com.unpredictableXsoft_delete.Students.entity.Student;
import com.unpredictableXsoft_delete.Students.service.StudentServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController
{
    private final StudentServiceHandler service;

    //Create
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(student));
    }

    //Get all students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(service.getAllStudent());
    }

    //Hard delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> sDelete(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.softDelete(id));
    }
}
