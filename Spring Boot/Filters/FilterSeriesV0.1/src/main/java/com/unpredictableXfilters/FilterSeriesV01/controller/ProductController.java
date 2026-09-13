package com.unpredictableXfilters.FilterSeriesV01.controller;

import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductRequestDTO;
import com.unpredictableXfilters.FilterSeriesV01.dtos.ProductResponseDTO;
import com.unpredictableXfilters.FilterSeriesV01.service.ProductServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/filters")
@AllArgsConstructor
public class ProductController
{
    private final ProductServiceHandler service;

    //create
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(requestDTO));
    }
}
