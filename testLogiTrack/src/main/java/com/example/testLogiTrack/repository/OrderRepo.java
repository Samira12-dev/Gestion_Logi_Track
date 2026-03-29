package com.example.testLogiTrack.repository;

import com.example.testLogiTrack.entity.Order;
import com.example.testLogiTrack.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findOrderByClient( Long ClientId);

    @Query("select count (o)from Order o")
    long countAllOrders();


}

