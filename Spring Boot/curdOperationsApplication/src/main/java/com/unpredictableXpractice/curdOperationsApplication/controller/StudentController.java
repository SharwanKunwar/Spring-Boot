package com.unpredictableXpractice.curdOperationsApplication.controller;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import com.unpredictableXpractice.curdOperationsApplication.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController
{

    private StudentService  studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public String create(@RequestBody StudentEntity studentEntity)
    {
        System.out.println("inside controller");
        StudentEntity createdStudent = studentService.createStudent(studentEntity);
        System.out.println("Exiting controller");
        return "Student create successfully";
    }

    @GetMapping
    public void getAllStudents()
    {
        // help to get all students
    }

    // update
    // delete



}
