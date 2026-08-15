package com.unpredictableXpractice.curdOperationsApplication.service;

import com.unpredictableXpractice.curdOperationsApplication.entity.StudentEntity;
import com.unpredictableXpractice.curdOperationsApplication.repository.StudentRepositoryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    private final StudentRepositoryHandler studentRepository;

    public StudentService(StudentRepositoryHandler studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Write
    public StudentEntity createStudent(StudentEntity student)
    {
        return studentRepository.save(student);
    }

    // Read all
    public List<StudentEntity> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }

    // Delete By id
    public void deleteById(Long id)
    {
        studentRepository.deleteById(id);
    }

    // Delete All
    public void deleteAllStudents()
    {
        studentRepository.deleteAll();
    }

    //update
    public StudentEntity updateStudent(StudentEntity student)
    {
        return studentRepository.updateStudent(student);
    }
}
