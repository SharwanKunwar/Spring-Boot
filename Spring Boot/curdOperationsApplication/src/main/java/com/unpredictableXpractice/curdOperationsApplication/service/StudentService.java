package com.unpredictableXpractice.curdOperationsApplication.service;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import com.unpredictableXpractice.curdOperationsApplication.repository.ManualStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    private ManualStudentRepository manualStudentRepository;

    public StudentService(ManualStudentRepository manualStudentRepository){
        this.manualStudentRepository = manualStudentRepository;
    }

    //Create
    public StudentEntity createStudent(StudentEntity student){
        System.out.println("inside Service");
        StudentEntity savedStudent = manualStudentRepository.saveStudent(student);
        System.out.println("Exiting service");
        return savedStudent;
    }








    //handle read
    //handle update
    // handle delete
}
