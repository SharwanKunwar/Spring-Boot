package com.example.DigitalXShop.analysis.controller;

import com.example.DigitalXShop.analysis.service.FilterServiceHelper;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.enums.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/filters")
public class AnalysisController
{
    private final FilterServiceHelper service;

    // Filter by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getByCategory(@PathVariable Category category)
    {
        return ResponseEntity.ok(service.filterByCategory(category));
    }
}
