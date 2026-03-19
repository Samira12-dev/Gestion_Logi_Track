package com.example.testLogiTrack.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String category;
    private  double price;
    private int quantitystock;
    @OneToMany(mappedBy = "product")
    private List<OrderLine>orderLineList;


    public Product(){}

    public Product(Long id, String nom, String category, double price, int quantitystock, List<OrderLine> orderLineList) {
        this.id = id;
        this.nom = nom;
        this.category = category;
        this.price = price;
        this.quantitystock = quantitystock;
        this.orderLineList = orderLineList;
    }
    public Product( String nom, String category, double price, int quantitystock, List<OrderLine> orderLineList) {
        this.nom = nom;
        this.category = category;
        this.price = price;
        this.quantitystock = quantitystock;
        this.orderLineList = orderLineList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantitystock() {
        return quantitystock;
    }

    public void setQuantitystock(int quantitystock) {
        this.quantitystock = quantitystock;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }
}
