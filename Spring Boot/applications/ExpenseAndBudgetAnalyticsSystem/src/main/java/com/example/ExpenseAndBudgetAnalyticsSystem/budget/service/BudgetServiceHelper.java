package com.example.ExpenseAndBudgetAnalyticsSystem.budget.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetResponseDTO;

import java.util.List;
import java.util.UUID;

public interface BudgetServiceHelper
{
    // Create
    BudgetResponseDTO create(BudgetRequestDTO requestDTO);

    // Get all
    List<BudgetResponseDTO> getAllBudget();

    // Get by id
    BudgetResponseDTO getById(UUID id);

    // Update
    BudgetResponseDTO updateBudget(UUID id, BudgetRequestDTO requestDTO);

    // Hard Delete
    String deleteHardly(UUID id);

    // Soft Delete
    String deleteSoftly(UUID id);
}
