package com.example.testLogiTrack.repository;

import com.example.testLogiTrack.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findProductByCategory(String category);

    List<Product> findProductByPriceLessThan(Double price);

    @Query("select p from Product p where p.quantitystock< 10")
    List<Product> findLowStockProducts();
}

