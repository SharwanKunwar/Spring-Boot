package com.example.ExpenseAndBudgetAnalyticsSystem.expense.repository;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID>
{
    // Manual queries
    Optional<Expense> findByIdAndDeletedFalse(UUID id);
    List<Expense> findByDeletedFalse();

}
