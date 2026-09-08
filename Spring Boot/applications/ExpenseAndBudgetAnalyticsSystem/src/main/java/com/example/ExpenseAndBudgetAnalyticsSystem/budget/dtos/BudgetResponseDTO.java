package com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.enums.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BudgetResponseDTO
{
    private UUID id;
    private Category category;
    private BigDecimal amount;
    private LocalDate month;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
