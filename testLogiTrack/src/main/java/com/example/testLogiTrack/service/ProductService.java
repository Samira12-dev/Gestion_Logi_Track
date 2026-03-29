package com.example.testLogiTrack.service;

import com.example.testLogiTrack.entity.Product;
import com.example.testLogiTrack.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepo productRepo;

    public  ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }
    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepo.findAll();
    }

    public Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    public void deleteProductById(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> getProductByCategory(String category){
        return productRepo.findProductByCategory(category);
    }
    public List<Product>getAllProductByPriceLessThan(Double price){
        return productRepo.findProductByPriceLessThan(price);
    }
    public List<Product> getAllByLowStock(){
        return productRepo.findLowStockProducts();
    }
}
