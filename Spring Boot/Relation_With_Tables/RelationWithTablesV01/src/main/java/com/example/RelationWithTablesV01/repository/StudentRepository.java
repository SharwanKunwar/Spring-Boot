package com.example.RelationWithTablesV01.repository;


import com.example.RelationWithTablesV01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>
{

}
