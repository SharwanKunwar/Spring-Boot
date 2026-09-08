package com.example.ExpenseAndBudgetAnalyticsSystem.budget.controller;

import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.dtos.BudgetResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.budget.service.BudgetServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/budgets")
@AllArgsConstructor
public class BudgetController
{
    private final BudgetServiceHelper service;

    //Create End point
    @PostMapping("/create")
    public ResponseEntity<BudgetResponseDTO> create(@Valid @RequestBody BudgetRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Get all Budgets
    @GetMapping("/all")
    public ResponseEntity<List<BudgetResponseDTO>> getAllBudgets()
    {
        return ResponseEntity.ok(service.getAllBudget());
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponseDTO> getById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<BudgetResponseDTO> updateBudget(@PathVariable UUID id, @RequestBody BudgetRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.updateBudget(id, requestDTO));
    }

    // Hard delete
    @DeleteMapping("/hard/{id}")
    public ResponseEntity<String> deleteHardly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteHardly(id));
    }

    // Soft delete
    @PatchMapping("/soft/{id}")
    public ResponseEntity<String> deleteSoftly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteSoftly(id));
    }
}
