package com.example.DigitalXShop.product.mapper;

import com.example.DigitalXShop.product.dtos.ProductRequestDTO;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper
{
    //DTO -> toEntity
    public Product toEntity(ProductRequestDTO requestDTO)
    {
        return Product.builder()
                .name(requestDTO.getName())
                .description(requestDTO.getDescription())
                .color(requestDTO.getColor())
                .price(requestDTO.getPrice())
                .category(requestDTO.getCategory())
                .stock(requestDTO.getStock())
                .build();
    }

    //Update entity
    public void update(Product product, ProductRequestDTO requestDTO)
    {
        product.setName(requestDTO.getName());
        product.setDescription(requestDTO.getDescription());
        product.setColor(requestDTO.getColor());
        product.setPrice(requestDTO.getPrice());
        product.setCategory(requestDTO.getCategory());
        product.setStock(requestDTO.getStock());

    }




    //Entity -> toResponse
    public ProductResponseDTO toResponse(Product product)
    {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .color(product.getColor())
                .price(product.getPrice())
                .category(product.getCategory())
                .stock(product.getStock())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .active(product.isActive())
                .build();
    }
}
