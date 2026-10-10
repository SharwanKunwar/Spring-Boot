package com.example.E_COM.service.implementation;

import com.example.E_COM.aspect.pointcuts.ApplicationPointcuts;
import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.dtos.ProductResponseDTO;
import com.example.E_COM.entity.Product;
import com.example.E_COM.mapper.ProductMapper;
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
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO)
    {
        Product product = ProductMapper.toEntity(productRequestDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toResponse(savedProduct);
    }


    @Override
    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public String deleteAllProducts()
    {
        productRepository.deleteAll();
        return "All products are gone : Deleted.";
    }
}
