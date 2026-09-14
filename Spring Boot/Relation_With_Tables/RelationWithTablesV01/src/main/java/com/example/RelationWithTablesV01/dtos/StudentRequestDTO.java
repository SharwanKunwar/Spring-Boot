package com.example.RelationWithTablesV01.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO
{
    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Age is required.")
    private int age;

}
