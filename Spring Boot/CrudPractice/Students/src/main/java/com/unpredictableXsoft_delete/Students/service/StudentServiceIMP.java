package com.unpredictableXsoft_delete.Students.service;

import com.unpredictableXsoft_delete.Students.entity.Student;
import com.unpredictableXsoft_delete.Students.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceIMP implements StudentServiceHandler
{
    private final StudentRepository repository;

    @Override
    public Student create(Student student)
    {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudent()
    {
        return repository.findAllByDeletedIsFalse();
    }

    @Override
    public void delete(UUID id)
    {
        repository.deleteById(id);
    }

    @Override
    public String softDelete(UUID id)
    {
        Student student = repository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new RuntimeException("Student not found"));

        student.setDeleted(true);
        repository.save(student);

        return "Student soft deleted successfully";
    }
}
