package com.example.E_COM.mapper;

import com.example.E_COM.dtos.ProductRequestDTO;
import com.example.E_COM.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper
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
}
