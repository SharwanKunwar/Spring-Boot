package com.example.ExpenseAndBudgetAnalyticsSystem.expense.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.exception.ResourceNotFoundException;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.entity.Expense;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.mapper.ExpenseMapper;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseServiceIMP implements ExpenseServiceHelper
{
    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;

    @Override
    public ExpenseResponseDTO create(ExpenseRequestDTO requestDTO)
    {
        Expense expense = mapper.toEntity(requestDTO);
        Expense createdExpense = repository.save(expense);
        return mapper.toResponse(createdExpense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpense()
    {
        List<Expense> expenses = repository.findByDeletedFalse();
        return expenses.stream().map(mapper::toResponse).toList();
    }

    @Override
    public ExpenseResponseDTO getExpenseById(UUID id)
    {
        Expense expense = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Expense Not Found"));
        return mapper.toResponse(expense);
    }

    @Override
    public ExpenseResponseDTO updateExpense(UUID id, ExpenseRequestDTO requestDTO) {
        return null;
    }

    @Override
    public String deleteHardly(UUID id)
    {
        Expense expense = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Income Not Found"));
        repository.delete(expense);
        return "Expense Deleted Successfully.";
    }

    @Override
    public String deleteSoftly(UUID id)
    {
        Expense expense = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Income Not Found"));
        expense.setDeleted(true);
        repository.save(expense);
        return "Expense Deleted Successfully.";
    }
}
