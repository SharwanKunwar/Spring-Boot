package com.example.ExpenseAndBudgetAnalyticsSystem.income.repository;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID>
{
    // manual queries
    Optional<Income> findByIdAndDeletedFalse(UUID id);
    List<Income> findByDeletedFalse();
}
