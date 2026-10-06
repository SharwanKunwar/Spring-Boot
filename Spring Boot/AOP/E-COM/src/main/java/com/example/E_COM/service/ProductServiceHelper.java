package com.example.E_COM.service;

import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.dtos.ProductResponseDTO;

import java.util.List;

public interface ProductServiceHelper
{
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();
}
