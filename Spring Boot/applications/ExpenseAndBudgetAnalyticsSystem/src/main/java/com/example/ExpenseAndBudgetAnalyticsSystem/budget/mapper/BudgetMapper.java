package com.example.ExpenseAndBudgetAnalyticsSystem.budget.mapper;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.entity.Budget;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper
{
    // DTO -> toEntity
    public Budget toEntity(BudgetRequestDTO requestDTO)
    {
        return Budget.builder()
                .category(requestDTO.getCategory())
                .amount(requestDTO.getAmount())
                .month(requestDTO.getMonth())
                .build();
    }

    //Update Entity
    public void toUpdateEntity(Budget budget, BudgetRequestDTO requestDTO)
    {
        budget.setCategory(requestDTO.getCategory());
        budget.setAmount(requestDTO.getAmount());
        budget.setMonth(requestDTO.getMonth());
    }

    //Entity -> toResponse
    public BudgetResponseDTO toResponse(Budget budget)
    {
        return BudgetResponseDTO.builder()
                .id(budget.getId())
                .category(budget.getCategory())
                .amount(budget.getAmount())
                .month(budget.getMonth())
                .createdAt(budget.getCreatedAt())
                .updatedAt(budget.getUpdatedAt())
                .build();
    }
}
