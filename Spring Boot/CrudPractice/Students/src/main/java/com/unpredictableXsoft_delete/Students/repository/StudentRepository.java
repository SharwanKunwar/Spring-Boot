package com.unpredictableXsoft_delete.Students.repository;

import com.unpredictableXsoft_delete.Students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByIdAndDeletedIsFalse(UUID id);
    List<Student> findAllByDeletedIsFalse();
}
