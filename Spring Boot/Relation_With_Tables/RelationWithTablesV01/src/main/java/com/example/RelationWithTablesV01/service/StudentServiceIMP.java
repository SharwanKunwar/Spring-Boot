package com.example.RelationWithTablesV01.service;

import com.example.RelationWithTablesV01.dtos.StudentRequestDTO;
import com.example.RelationWithTablesV01.dtos.StudentResponseDTO;
import com.example.RelationWithTablesV01.entity.IdentityCard;
import com.example.RelationWithTablesV01.entity.Student;
import com.example.RelationWithTablesV01.mapper.StudentMapper;
import com.example.RelationWithTablesV01.repository.IdentityCardRepository;
import com.example.RelationWithTablesV01.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceIMP implements StudentServiceHelper
{
    private final StudentRepository repository;
    private final IdentityCardRepository identityCardRepository;
    private final StudentMapper mapper;


    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO)
    {
        Student student = mapper.toEntity(requestDTO);
        Student savedStudent = repository.save(student);
        IdentityCard identityCard = IdentityCard.builder().student(savedStudent).build();
        IdentityCard savedIdentityCard = identityCardRepository.save(identityCard);
        return mapper.toResponse(savedStudent, savedIdentityCard);
    }

    @Override
    public List<StudentResponseDTO> getAllStudent()
    {
        List<Student> students = repository.findAll();
        return students.stream().map((student -> {
            IdentityCard identityCard = identityCardRepository
                    .findByStudent_Id(student.getId());
            return mapper.toResponse(student, identityCard);
        })).toList();
    }

}
