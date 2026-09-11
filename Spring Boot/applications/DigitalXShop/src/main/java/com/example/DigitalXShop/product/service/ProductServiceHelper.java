package com.example.DigitalXShop.product.service;

import com.example.DigitalXShop.product.dtos.ProductRequestDTO;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import java.util.List;
import java.util.UUID;

public interface ProductServiceHelper
{
    /** Create a new product. */
    ProductResponseDTO create(ProductRequestDTO requestDTO);

    /** Get all products. */
    List<ProductResponseDTO> getAllProduct();

    /** Get product by ID. */
    ProductResponseDTO getById(UUID id);

    /** Update product by ID. */
    ProductResponseDTO updateProduct(UUID id, ProductRequestDTO requestDTO);

    /** Permanently delete product by ID. */
    String delete(UUID id);

    /** Soft delete product by ID. */
    String deleteSoftly(UUID id);

}
