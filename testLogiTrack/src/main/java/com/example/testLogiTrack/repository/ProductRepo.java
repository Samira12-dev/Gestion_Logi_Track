package com.example.testLogiTrack.repository;

import com.example.testLogiTrack.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
