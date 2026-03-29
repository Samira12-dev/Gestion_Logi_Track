package com.example.testLogiTrack.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id ;
    private LocalDate dateOrder;
    private  String status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "orders")
    private List<OrderLine> orderLineList;

   public Order(){}

    public Order(Long id, LocalDate dateOrder, String status, Client client, List<OrderLine> orderLineList) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.status = status;
        this.client = client;
        this.orderLineList = orderLineList;
    }
    public Order( LocalDate dateOrder, String status, Client client, List<OrderLine> orderLineList) {
        this.dateOrder = dateOrder;
        this.status = status;
        this.client = client;
        this.orderLineList = orderLineList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }
}
