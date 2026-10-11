package com.practice.CustomAnnoatation.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class BookRequestDTO
{
    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is required.")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
    @DecimalMax(value = "100.00", message = "Price must not exceed 100.00")
    private BigDecimal price;
}
