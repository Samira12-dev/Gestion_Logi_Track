package com.example.testLogiTrack.controller;

import com.example.testLogiTrack.entity.Product;
import com.example.testLogiTrack.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/products")
public class ProductController {
    private final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
         productService.deleteProductById(id);
    }
    @GetMapping("/category/{category}")
    public List<Product> getAllProductByCategory(@PathVariable String category){
        return productService.getProductByCategory(category);
    }
    @GetMapping("/price/{price}")
    public List<Product> getAllProductByPriceLessThan(@PathVariable Double price){
        return productService.getAllProductByPriceLessThan(price);
    }
    @GetMapping("/low-stock")
    public List<Product> getAllPrdocutByLowStock(){
        return productService.getAllByLowStock();
    }
}
