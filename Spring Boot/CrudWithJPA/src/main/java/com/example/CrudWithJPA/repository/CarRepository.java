package com.example.CrudWithJPA.repository;

import com.example.CrudWithJPA.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID>
{
    // Other sql queries
}
