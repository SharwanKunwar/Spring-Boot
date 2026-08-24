package com.unpredictableXpractice.StoreX.controller;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;
import com.unpredictableXpractice.StoreX.service.ProductServiceHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceHandler productService;

    // Create
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request));
    }


    // Get all product
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts()
    {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    // Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable UUID id, @Valid @RequestBody ProductRequestDTO request)
    {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }


    // Delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}