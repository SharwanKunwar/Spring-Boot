package com.example.ExpenseAndBudgetAnalyticsSystem.expense.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ExpenseServiceHelper
{
    // Create
    ExpenseResponseDTO create(ExpenseRequestDTO requestDTO);
    // Get all
    List<ExpenseResponseDTO> getAllExpense();
    // Get expense by id
    ExpenseResponseDTO getExpenseById(UUID id);
    // Update expense
    ExpenseResponseDTO updateExpense(UUID id, ExpenseRequestDTO requestDTO);
    // Hard delete
    String deleteHardly(UUID id);
    // Soft delete
    String deleteSoftly(UUID id);
}
