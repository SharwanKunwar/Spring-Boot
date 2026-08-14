package com.unpredictableXpractice.curdOperationsApplication.repository;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;

import java.util.List;

public interface StudentRepositoryHandler {
    StudentEntity save(StudentEntity studentEntity);
    List<StudentEntity> getAllStudents();
    void deleteById(long id);
    void deleteAll();
}
