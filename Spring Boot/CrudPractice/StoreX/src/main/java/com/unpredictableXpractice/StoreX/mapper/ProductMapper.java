package com.unpredictableXpractice.StoreX.mapper;

import com.unpredictableXpractice.StoreX.dtos.ProductRequestDTO;
import com.unpredictableXpractice.StoreX.dtos.ProductResponseDTO;
import com.unpredictableXpractice.StoreX.entity.Product;

public class ProductMapper
{

    // DTO → Entity
    public static Product toEntity(ProductRequestDTO dto)
    {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .category(dto.getCategory())
                .build();
    }

    // RequestDTO → Existing Entity
    public static void updateEntity(Product product, ProductRequestDTO request)
    {
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(request.getCategory());
    }

    // Entity → Response DTO
    public static ProductResponseDTO toResponseDTO(Product product)
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