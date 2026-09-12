package com.example.DigitalXShop.analysis.service;

import com.example.DigitalXShop.analysis.repository.FilterRepository;
import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.entity.Product;
import com.example.DigitalXShop.product.enums.Category;
import com.example.DigitalXShop.product.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceIMP implements FilterServiceHelper
{
    private final FilterRepository repository;
    private final ProductMapper mapper;

    // Filter by category
    @Override
    public List<ProductResponseDTO> filterByCategory(Category category)
    {
        List<Product> products = repository.findByCategory(category);
        return products.stream().map(mapper::toResponse).toList();
    }


}
