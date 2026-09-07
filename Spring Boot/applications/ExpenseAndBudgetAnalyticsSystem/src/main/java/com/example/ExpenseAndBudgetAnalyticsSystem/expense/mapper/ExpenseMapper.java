package com.example.ExpenseAndBudgetAnalyticsSystem.expense.mapper;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.entity.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper
{
    // DTO -> toEntity
    public Expense toEntity(ExpenseRequestDTO requestDTO)
    {
        Expense expense = new Expense();
        expense.setTitle(requestDTO.getTitle());
        expense.setDescription(requestDTO.getDescription());
        expense.setAmount(requestDTO.getAmount());
        expense.setCategory(requestDTO.getCategory());
        expense.setPaymentMethod(requestDTO.getPaymentMethod());
        expense.setExpenseDate(requestDTO.getExpenseDate());
        return expense;
    }

    // Entity -> toResponse
    public ExpenseResponseDTO toResponse(Expense expense)
    {
        ExpenseResponseDTO responseDTO = new ExpenseResponseDTO();
        responseDTO.setId(expense.getId());
        responseDTO.setTitle(expense.getTitle());
        responseDTO.setDescription(expense.getDescription());
        responseDTO.setAmount(expense.getAmount());
        responseDTO.setCategory(expense.getCategory());
        responseDTO.setPaymentMethod(expense.getPaymentMethod());
        responseDTO.setExpenseDate(expense.getExpenseDate());
        responseDTO.setCreatedAt(expense.getCreatedAt());
        responseDTO.setUpdatedAt(expense.getUpdatedAt());
        return responseDTO;
    }
}
