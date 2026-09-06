package com.example.ExpenseAndBudgetAnalyticsSystem.income.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.exception.ResourceNotFoundException;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.entity.Income;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.mapper.IncomeMapper;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IncomeServiceIMP implements IncomeServiceHelper
{
    private final IncomeRepository repository;
    private final IncomeMapper mapper;


    @Override
    public IncomeResponseDTO create(IncomeRequestDTO requestDTO)
    {
        Income income = mapper.toEntity(requestDTO);
        Income savedIncome = repository.save(income);
        return mapper.toResponse(savedIncome);
    }

    @Override
    public List<IncomeResponseDTO> getAllIncome()
    {
        List<Income> incomes = repository.findByDeletedFalse();
        return incomes.stream().map(mapper::toResponse).toList();
    }

    @Override
    public IncomeResponseDTO getIncomeById(UUID id)
    {
        Optional<Income> income = repository.findByIdAndDeletedFalse(id);
        return income.map(mapper::toResponse).orElseThrow(()-> new ResourceNotFoundException("Income Not Found"));
    }

    @Override
    public IncomeResponseDTO updateIncome(UUID id, IncomeRequestDTO requestDTO)
    {

        Income income = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Income Not Found"));
        mapper.toUpdateEntity(income, requestDTO);
        repository.save(income);
        return mapper.toResponse(income);
    }

    @Override
    public String deleteHardly(UUID id)
    {
        Income income = repository.findByIdAndDeletedFalse(id).orElseThrow(()-> new ResourceNotFoundException("Income Not Found"));
        repository.delete(income);
        return "Income is deleted successfully";
    }

    @Override
    public String deleteSoftly(UUID id)
    {
        Income income = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Income Not Found"));
        income.setDeleted(true);
        repository.save(income);
        return "Income is deleted successfully";
    }
}
