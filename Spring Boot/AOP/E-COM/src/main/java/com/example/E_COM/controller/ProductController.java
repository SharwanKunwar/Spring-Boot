package com.example.E_COM.controller;

import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.dtos.ProductResponseDTO;
import com.example.E_COM.service.ProductServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController
{
    private final ProductServiceHelper  service;

    //create product
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(productRequestDTO));
    }

    // get all products
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts()
    {
        return ResponseEntity.ok(service.getAllProducts());
    }

    // delete all product
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllProducts()
    {
        return ResponseEntity.ok(service.deleteAllProducts());
    }
}
