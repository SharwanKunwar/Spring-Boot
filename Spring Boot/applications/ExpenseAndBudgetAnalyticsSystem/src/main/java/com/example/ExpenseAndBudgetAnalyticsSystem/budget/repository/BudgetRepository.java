package com.example.ExpenseAndBudgetAnalyticsSystem.budget.repository;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID>
{
    // Manual Queries
    Optional<Budget> findByIdAndDeletedFalse(UUID id);
    List<Budget> findByDeletedFalse();
}
