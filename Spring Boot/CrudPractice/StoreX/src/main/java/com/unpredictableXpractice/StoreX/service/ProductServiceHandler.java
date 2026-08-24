package com.unpredictableXpractice.StoreX.service;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductServiceHandler {

    // create project
    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    // Get all product
    List<ProductResponseDTO> getAllProducts();

    // Get product by id
    ProductResponseDTO getProductById(UUID id);

    // Update product
    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request);

    // Delete product
    void deleteProduct(UUID id);
}