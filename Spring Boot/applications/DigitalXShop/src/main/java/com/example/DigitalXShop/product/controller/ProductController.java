package com.example.DigitalXShop.product.controller;

import com.example.DigitalXShop.product.dtos.ProductRequestDTO;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.service.ProductServiceHelper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController
{
    private final ProductServiceHelper service;

    // Create a new product
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    // Retrieve all products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct()
    {
        return ResponseEntity.ok(service.getAllProduct());
    }


    // Retrieve a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.getProductById(id));
    }

    // Update an existing product
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@PathVariable UUID id, @RequestBody ProductRequestDTO requestDTO)
    {
        return ResponseEntity.ok(service.updateProduct(id, requestDTO));
    }

    // Permanently delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.delete(id));
    }

    // Soft delete a product
    @PatchMapping("/sDelete/{id}")
    public ResponseEntity<String> deleteSoftly(@PathVariable UUID id)
    {
        return ResponseEntity.ok(service.deleteSoftly(id));
    }

}
