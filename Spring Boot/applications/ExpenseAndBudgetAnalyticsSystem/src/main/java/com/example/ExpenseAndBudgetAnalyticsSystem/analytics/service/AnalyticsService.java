package com.example.ExpenseAndBudgetAnalyticsSystem.analytics.service;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.repository.BudgetRepository;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.repository.ExpenseRepository;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnalyticsService
{
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;


}
