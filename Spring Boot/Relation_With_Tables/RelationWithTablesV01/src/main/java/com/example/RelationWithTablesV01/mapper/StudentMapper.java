package com.example.RelationWithTablesV01.mapper;

import com.example.RelationWithTablesV01.dtos.StudentRequestDTO;
import com.example.RelationWithTablesV01.dtos.StudentResponseDTO;
import com.example.RelationWithTablesV01.entity.IdentityCard;
import com.example.RelationWithTablesV01.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper
{
    //DTO -> toEntity
    public Student toEntity(StudentRequestDTO requestDTO){
        return Student.builder()
                .name(requestDTO.getName())
                .age(requestDTO.getAge())
                .build();
    }

    // Entity -> toResponse
    public StudentResponseDTO toResponse(Student student, IdentityCard identityCard)
    {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .cardID(identityCard != null ? identityCard.getCardID() : null)
                .cardNumber(identityCard != null ? identityCard.getCardNumber() : null)
                .build();
    }


}
