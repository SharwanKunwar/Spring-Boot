package com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos;


import com.example.ExpenseAndBudgetAnalyticsSystem.income.enums.Source;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRequestDTO
{

    @NotBlank(message = "Title is required")
    @Size(min=3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 300, message = "Description can not exceed 300 character")
    private String description;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Source is required")
    private Source source;

    @NotNull(message = "Income date is required")
    private LocalDateTime incomeDate;

}
