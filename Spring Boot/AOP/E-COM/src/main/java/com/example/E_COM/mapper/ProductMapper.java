package com.example.E_COM.mapper;

import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.dtos.ProductResponseDTO;
import com.example.E_COM.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper
{
    //DTO to toEntity
    public static Product toEntity(ProductRequestDTO requestDTO)
    {
        return Product.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .price(requestDTO.getPrice())
                .quantity(requestDTO.getQuantity())
                .category(requestDTO.getCategory())
                .build();
    }

    // Entity -> Response DTO
    public static ProductResponseDTO toResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(product.getCategory())
                .build();
    }
}
