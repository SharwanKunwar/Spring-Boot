package com.unpredictableXpractice.StoreX.repository;

import com.unpredictableXpractice.StoreX.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>
{
//    This interface provides
//    save()
//    findById()
//    findAll()
//    delete()
//    deleteById()
//    existsById()
//    count()
}
