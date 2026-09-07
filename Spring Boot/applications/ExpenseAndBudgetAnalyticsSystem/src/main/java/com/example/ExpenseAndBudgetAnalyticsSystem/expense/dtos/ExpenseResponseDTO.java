package com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.enums.Category;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ExpenseResponseDTO
{
    private UUID id;
    private String title;
    private String description;
    private BigDecimal amount;
    private Category category;
    private PaymentMethod paymentMethod;
    private LocalDateTime expenseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
