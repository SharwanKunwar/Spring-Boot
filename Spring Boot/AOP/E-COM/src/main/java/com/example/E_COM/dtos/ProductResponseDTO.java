package com.example.E_COM.dtos;

import com.example.E_COM.enums.Category;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
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