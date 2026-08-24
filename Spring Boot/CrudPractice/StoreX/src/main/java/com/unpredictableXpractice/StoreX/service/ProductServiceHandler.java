package com.unpredictableXpractice.StoreX.service;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductServiceHandler {

    ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(UUID id);

    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request);

    void deleteProduct(UUID id);
}