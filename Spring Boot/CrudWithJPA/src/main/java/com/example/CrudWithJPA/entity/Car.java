package com.example.CrudWithJPA.entity;

import com.example.CrudWithJPA.enums.CarCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car
{
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String model;

    @Enumerated(EnumType.STRING)
    private CarCategory category;
    private String color;
    private String engine;
    private BigDecimal price;
    private int speed;
    private String imageUrl;
    private String description;
}
