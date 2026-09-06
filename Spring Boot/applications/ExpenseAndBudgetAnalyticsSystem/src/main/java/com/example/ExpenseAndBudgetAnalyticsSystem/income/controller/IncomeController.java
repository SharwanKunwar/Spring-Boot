package com.example.ExpenseAndBudgetAnalyticsSystem.income.controller;

import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeRequestDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.dtos.IncomeResponseDTO;
import com.example.ExpenseAndBudgetAnalyticsSystem.income.service.IncomeServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/incomes")
@AllArgsConstructor
public class IncomeController
{
    private final IncomeServiceHelper service;

    // create income End Point
    @PostMapping("/create")
    public ResponseEntity<IncomeResponseDTO> create(@Valid @RequestBody IncomeRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(service.create(requestDTO));
    }

    // Get all incomes End Point
    @GetMapping("/all")
    public ResponseEntity<List<IncomeResponseDTO>> getAllIncome()
    {
        return ResponseEntity.ok(service.getAllIncome());
    }

    // Get by id End Point
    @GetMapping("/{id}")
    public ResponseEntity<IncomeResponseDTO> getIncomeById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getIncomeById(id));
    }

    // Update income
    @PutMapping("/update/{id}")
    public ResponseEntity<IncomeResponseDTO> updateIncome(@PathVariable UUID id, @RequestBody IncomeRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.updateIncome(id, requestDTO));
    }

    // Hard delete
    @DeleteMapping("/hDelete/{id}")
    public ResponseEntity<String> deleteIncomeHardly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteHardly(id));
    }

    // Soft delete
    @PatchMapping("/sDelete/{id}")
    public ResponseEntity<String> deleteIncomeSoftly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteSoftly(id));
    }
}
