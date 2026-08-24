package com.unpredictableXpractice.StoreX.service.implementations;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;
import com.unpredictableXpractice.StoreX.entity.Product;
import com.unpredictableXpractice.StoreX.exception.ProductNotFoundException;
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
    public ProductResponseDTO create(ProductRequestDTO request) {

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(request.getCategory())
                .available(request.getStock() > 0)
                .build();

        Product savedProduct = productRepository.save(product);

        return mapToResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts()
    {
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(UUID id)
    {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return mapToResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID id, ProductRequestDTO request)
    {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());
        product.setAvailable(request.getStock() > 0);

        Product updatedProduct = productRepository.save(product);

        return mapToResponseDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id)
    {

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(product);
    }

    private ProductResponseDTO mapToResponseDTO(Product product)
    {

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getAvailable(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}