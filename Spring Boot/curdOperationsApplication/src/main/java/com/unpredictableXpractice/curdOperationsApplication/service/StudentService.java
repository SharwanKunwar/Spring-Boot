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

    //write
    public StudentEntity createStudent(StudentEntity student){

        return studentRepository.save(student);
    }

    //read
    public List<StudentEntity> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    //update
    //delete
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }
}
