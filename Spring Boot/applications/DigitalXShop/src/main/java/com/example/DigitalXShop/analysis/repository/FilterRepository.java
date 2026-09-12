package com.example.DigitalXShop.analysis.repository;

import com.example.DigitalXShop.product.entity.Product;
import com.example.DigitalXShop.product.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface FilterRepository extends JpaRepository<Product, UUID>
{
    //Custom queries for filters
    //--------------------------

    //Filter by Category
    List<Product> findByCategory(Category category);
}
