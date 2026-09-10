package com.example.DigitalXShop.product.dtos;

import com.example.DigitalXShop.product.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO
{
    private UUID id;
    private String name;
    private String description;
    private String color;
    private BigDecimal price;
    private Category category;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active = true;
}
