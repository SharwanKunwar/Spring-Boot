package com.unpredictableXpractice.StoreX.dtos;

import com.unpredictableXpractice.StoreX.enums.Category;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    @Size(
            min = 2,
            max = 100,
            message = "Product name must be between 2 and 100 characters"
    )
    private String name;

    @Size(
            max = 500,
            message = "Description cannot exceed 500 characters"
    )
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(
            value = "0.01",
            message = "Price must be greater than 0"
    )
    @Digits(
            integer = 10,
            fraction = 2,
            message = "Invalid price format"
    )
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @Min(
            value = 0,
            message = "Stock cannot be negative"
    )
    private Integer stock;

    @NotNull(message = "Category is required")
    private Category category;
}