package com.unpredictableXpractice.curdOperationsApplication.controller;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import com.unpredictableXpractice.curdOperationsApplication.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{

    private StudentService  studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentEntity> create(@RequestBody StudentEntity studentEntity)
    {
        StudentEntity savedStudent = studentService.createStudent(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentEntity>> getAll()
    {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id)
    {
        studentService.deleteById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll()
    {
        studentService.deleteAllStudents();
    }

    @PutMapping("/update")
    public StudentEntity update(@RequestBody StudentEntity studentEntity)
    {
        return studentService.updateStudent(studentEntity);
    }


}
