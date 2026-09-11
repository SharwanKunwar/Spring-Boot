package com.example.DigitalXShop.product.service;

import com.example.DigitalXShop.exceptions.ResourceNotFound;
import com.example.DigitalXShop.product.dtos.ProductRequestDTO;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.entity.Product;
import com.example.DigitalXShop.product.mapper.ProductMapper;
import com.example.DigitalXShop.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceIMP implements ProductServiceHelper
{

    private final ProductRepository repository;
    private final ProductMapper mapper;


    @Override
    public ProductResponseDTO create(ProductRequestDTO requestDTO)
    {
        Product product = mapper.toEntity(requestDTO);
        Product savedProduct = repository.save(product);
        return mapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProduct()
    {
        List<Product> products = repository.findByDeletedFalse();
        return products.stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProductResponseDTO getProductById(UUID id)
    {
        Product product = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
        return mapper.toResponse(product);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO requestDTO)
    {
        Product product = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
        mapper.toUpdateEntity(product, requestDTO);
        repository.save(product);
        return mapper.toResponse(product);
    }

    @Override
    public String delete(UUID id)
    {
        Product product = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
        repository.delete(product);
        return "Product Deleted Successfully";
    }

    @Override
    public String deleteSoftly(UUID id)
    {
        Product product = repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFound("Product Not Found"));
        product.setDeleted(true);
        repository.save(product);
        return "Product Deleted Successfully";
    }
}
