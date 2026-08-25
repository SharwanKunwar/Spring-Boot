package com.unpredictableXpractice.StoreX.service.implementations;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;
import com.unpredictableXpractice.StoreX.entity.Product;
import com.unpredictableXpractice.StoreX.exception.ProductNotFoundException;
import com.unpredictableXpractice.StoreX.mapper.ProductMapper;
import com.unpredictableXpractice.StoreX.repository.ProductRepository;
import com.unpredictableXpractice.StoreX.service.ProductServiceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceIMP implements ProductServiceHandler
{

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO create(ProductRequestDTO request)
    {
        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts()
    {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(UUID id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return ProductMapper.toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        ProductMapper.updateEntity(product, request);
        Product updatedProduct = productRepository.save(product);

        return ProductMapper.toResponseDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id)
    {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
    }
}