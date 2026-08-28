package com.unpredictableXpractice.Books.dtos;

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
public class BookResponseDTO
{
    private UUID id;
    private String title;
    private String description;
    private String author;
    private Integer pages;
    private BigDecimal price;
}
