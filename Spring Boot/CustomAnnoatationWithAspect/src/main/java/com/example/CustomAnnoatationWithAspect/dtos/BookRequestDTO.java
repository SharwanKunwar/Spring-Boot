package com.example.CustomAnnoatationWithAspect.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class BookRequestDTO
{
    private String title;
    private String author;
    private BigDecimal price;
}
