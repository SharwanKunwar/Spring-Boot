package com.example.DigitalXShop.product.repository;

import com.example.DigitalXShop.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>
{
    // Manual Queries
    Optional<Product> findByIdAndDeletedFalse(UUID id);
    List<Product> findByDeletedFalse();
}
