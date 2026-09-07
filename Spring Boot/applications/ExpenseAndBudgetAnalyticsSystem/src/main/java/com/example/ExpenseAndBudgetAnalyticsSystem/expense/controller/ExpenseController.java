package com.example.ExpenseAndBudgetAnalyticsSystem.expense.controller;

import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.dtos.ExpenseResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.expense.service.ExpenseServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
