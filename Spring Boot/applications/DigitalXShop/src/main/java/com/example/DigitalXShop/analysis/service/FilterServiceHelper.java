package com.example.DigitalXShop.analysis.service;

import com.example.DigitalXShop.product.dtos.ProductResponseDTO;
import com.example.DigitalXShop.product.enums.Category;

import java.util.List;

public interface FilterServiceHelper
{
    // Get all filtered products by category
    List<ProductResponseDTO> filterByCategory(Category category);
}
