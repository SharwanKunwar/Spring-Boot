package com.example.ExpenseAndBudgetAnalyticsSystem.budget.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.entity.Budget;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.mapper.BudgetMapper;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.repository.BudgetRepository;
import com.example.ExpenseAndBudgetAnalyticsSystem.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BudgetServiceIMP implements BudgetServiceHelper
{
    private final BudgetRepository repository;
    private final BudgetMapper mapper;

    @Override
    public BudgetResponseDTO create(BudgetRequestDTO requestDTO)
    {
        Budget budget = mapper.toEntity(requestDTO);
        Budget savedBudget = repository.save(budget);
        return mapper.toResponse(savedBudget);
    }

    @Override
    public List<BudgetResponseDTO> getAllBudget()
    {
        List<Budget> budgets = repository.findByDeletedFalse();
        return budgets.stream().map(mapper::toResponse).toList();
    }

    @Override
    public BudgetResponseDTO getById(UUID id)
    {
        Budget budget = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Budget Not Found"));
        return mapper.toResponse(budget);
    }

    @Override
    public BudgetResponseDTO updateBudget(UUID id, BudgetRequestDTO requestDTO)
    {
        Budget budget = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Budget Not Found"));
        mapper.toUpdateEntity(budget,requestDTO);
        repository.save(budget);
        return mapper.toResponse(budget);
    }

    @Override
    public String deleteHardly(UUID id)
    {
        Budget budget = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Budget Not Found"));
        repository.delete(budget);
        return "Budget Deleted Successfully";
    }

    @Override
    public String deleteSoftly(UUID id)
    {
        Budget budget = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Budget Not Found"));
        budget.setDeleted(true);
        repository.save(budget);
        return "Budget Deleted Successfully";
    }
}
