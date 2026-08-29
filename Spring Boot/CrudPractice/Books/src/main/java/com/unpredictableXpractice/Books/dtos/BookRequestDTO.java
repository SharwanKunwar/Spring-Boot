package com.unpredictableXpractice.Books.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO
{
    @NotBlank(message = "Title is required.")
    @Size(min = 3, max = 30 , message = "title must be within 3 to 30 characters")
    private String title;

    @NotBlank(message = "Description is required.")
    @Size(max = 300, message = "Description must be within 300 characters")
    private String description;

    @NotBlank(message = "Author is required.")
    @Size(min = 3, max = 20, message = "Author must be within 20 characters")
    private String author;

    @NotNull(message = "Pages are required")
    @Positive(message = "Pages must be greater than 0")
    private Integer pages;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;
}
