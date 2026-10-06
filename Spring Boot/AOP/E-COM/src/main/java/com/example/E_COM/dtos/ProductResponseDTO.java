package com.example.E_COM.dtos;

import com.example.E_COM.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO
{
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private Category category;
}