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
@RequestMapping("/api/expenses")
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
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable UUID id, @RequestBody ExpenseRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.updateExpense(id, requestDTO));
    }

    // // Hard delete
    @DeleteMapping("/hard/{id}")
    public ResponseEntity<String> hDelete(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteHardly(id));
    }

    // Soft delete
    @PatchMapping("/soft/{id}")
    public ResponseEntity<String> sDelete(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteSoftly(id));
    }


}
