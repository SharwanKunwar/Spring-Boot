package com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.enums.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class IncomeResponseDTO
{
    private UUID id;
    private String title;
    private String description;
    private BigDecimal amount;
    private Source source;
    private LocalDateTime incomeDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
