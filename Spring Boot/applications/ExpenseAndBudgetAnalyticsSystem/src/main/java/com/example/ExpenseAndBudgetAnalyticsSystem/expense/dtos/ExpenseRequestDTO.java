package com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.enums.Category;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDTO
{
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be in between 3 to 100 character")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 300, message = "Description must be within 300 character")
    private String description;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "PaymentMethod is required")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Expense Date is required")
    private LocalDateTime expenseDate;
}
