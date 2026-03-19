package com.example.testLogiTrack.repository;

import com.example.testLogiTrack.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepo extends JpaRepository<OrderLine,Long> {
}
