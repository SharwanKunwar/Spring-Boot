package com.example.ExpenseAndBudgetAnalyticsSystem.income.repository;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID>
{
    // manual queries
}
