package com.unpredictableXsoft_delete.Students.service;

import com.unpredictableXsoft_delete.Students.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentServiceHandler {
    Student create(Student student);
    List<Student> getAllStudent();
    void delete(UUID id);
    String softDelete(UUID id);
}
