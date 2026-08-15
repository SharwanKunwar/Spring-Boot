package com.unpredictableXpractice.curdOperationsApplication.repository;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;

import java.util.List;

public interface StudentRepositoryHandler {
    // W
    StudentEntity save(StudentEntity studentEntity);
    // R
    List<StudentEntity> getAllStudents();
    //D
    void deleteById(long id);
    void deleteAll();
    //U
    StudentEntity updateStudent(StudentEntity student);
}
