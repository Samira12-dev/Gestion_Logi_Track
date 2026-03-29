package com.example.testLogiTrack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String email;
    private  String telephone;
    private String ville;
    @OneToMany(mappedBy = "client")
    private List<Order> orderList;


    public  Client(){}

    public Client(Long id, String name, String email, String telephone, String ville, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.orderList = orderList;
    }
    public Client(String name, String email, String telephone, String ville, List<Order> orderList) {

        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}

