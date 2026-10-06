package com.example.E_COM.service.implementation;

import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.dtos.ProductResponseDTO;
import com.example.E_COM.repository.ProductRepository;
import com.example.E_COM.service.ProductServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceHelper
{
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }
}
