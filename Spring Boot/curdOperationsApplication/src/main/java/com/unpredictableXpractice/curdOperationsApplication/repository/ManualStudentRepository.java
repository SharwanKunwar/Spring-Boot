package com.unpredictableXpractice.curdOperationsApplication.repository;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class ManualStudentRepository {

    public StudentEntity saveStudent(StudentEntity student){
        System.out.println("Inside Manual Repository");
        System.out.println("Sending data to database");
        System.out.println("Exiting Manual Repository");
        return student;
    }
}
