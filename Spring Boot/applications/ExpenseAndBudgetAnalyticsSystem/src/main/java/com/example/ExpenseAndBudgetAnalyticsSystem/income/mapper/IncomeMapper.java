package com.example.ExpenseAndBudgetAnalyticsSystem.income.mapper;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.entity.Income;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper
{

    // DTO -> toEntity
    public Income toEntity(IncomeRequestDTO requestDTO)
    {
        Income income = new Income();
        income.setTitle(requestDTO.getTitle());
        income.setDescription(requestDTO.getDescription());
        income.setAmount(requestDTO.getAmount());
        income.setSource(requestDTO.getSource());
        income.setIncomeDate(requestDTO.getIncomeDate());
        return income;
    }

    // Entity to ResponseDTO
    public IncomeResponseDTO toResponse(Income income)
    {
        IncomeResponseDTO responseDTO = new IncomeResponseDTO();
        responseDTO.setTitle(income.getTitle());
        responseDTO.setDescription(income.getDescription());
        responseDTO.setAmount(income.getAmount());
        responseDTO.setSource(income.getSource());
        responseDTO.setIncomeDate(income.getIncomeDate());

        return responseDTO;
    }

}
