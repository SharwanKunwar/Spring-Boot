package com.practice.CustomAnnoatation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class BookResponseDTO
{
    private String title;
    private String description;
    private BigDecimal price;
}
