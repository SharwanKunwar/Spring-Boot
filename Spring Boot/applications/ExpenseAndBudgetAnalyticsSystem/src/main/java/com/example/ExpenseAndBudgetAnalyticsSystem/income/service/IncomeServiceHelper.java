package com.example.ExpenseAndBudgetAnalyticsSystem.income.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IncomeServiceHelper
{
    // Create
    IncomeResponseDTO create(IncomeRequestDTO requestDTO);
    // Get all Income
    List<IncomeResponseDTO> getAllIncome();
    // Get income by id
    IncomeResponseDTO getIncomeById(UUID id);
    // Update income
    IncomeResponseDTO updateIncome(UUID id, IncomeRequestDTO requestDTO);
    // Hard delete
    String deleteHardly(UUID id);
    // Soft delete
    String deleteSoftly(UUID id);

}
