package com.example.RelationWithTablesV01.service;

import com.example.RelationWithTablesV01.dtos.StudentRequestDTO;
import com.example.RelationWithTablesV01.dtos.StudentResponseDTO;
import java.util.List;

public interface StudentServiceHelper
{
    StudentResponseDTO createStudent(StudentRequestDTO requestDTO);
    List<StudentResponseDTO> getAllStudent();
}
