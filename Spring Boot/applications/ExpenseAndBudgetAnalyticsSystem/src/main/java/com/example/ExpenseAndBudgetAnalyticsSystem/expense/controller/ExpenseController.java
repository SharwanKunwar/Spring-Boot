package com.example.ExpenseAndBudgetAnalyticsSystem.expense.controller;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.service.ExpenseServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ExpenseController
{
    private final ExpenseServiceHelper service;

    // Create
    @PostMapping("/create")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@Valid @RequestBody ExpenseRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Get All Expense
    @GetMapping("/all")
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpense()
    {
        return ResponseEntity.ok(service.getAllExpense());
    }

    // Update expense
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(UUID uuid, ExpenseRequestDTO requestDTO)
    {

    }


}
