package com.unpredictableXpractice.StoreX.dtos;

import com.unpredictableXpractice.StoreX.enums.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private Integer stock;
    private Category category;
    private Boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}