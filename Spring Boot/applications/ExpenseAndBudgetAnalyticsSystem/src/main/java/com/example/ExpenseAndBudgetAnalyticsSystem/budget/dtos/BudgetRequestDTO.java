package com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.enums.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BudgetRequestDTO
{
    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Month is required")
    private LocalDate month;
}
