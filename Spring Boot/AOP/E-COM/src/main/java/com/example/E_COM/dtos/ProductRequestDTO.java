package com.example.E_COM.dtos;

import com.example.E_COM.enums.Category;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Product name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Product description is required")
    @Size(max = 300, message = "Product description must not exceed 300 characters")
    private String description;

    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 10 integer digits and 2 decimal places")
    private BigDecimal price;

    @NotNull(message = "Product quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Long quantity;

    @NotNull(message = "Product category is required")
    private Category category;
}