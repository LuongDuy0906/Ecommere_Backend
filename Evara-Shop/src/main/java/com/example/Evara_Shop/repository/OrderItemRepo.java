package com.example.Evara_Shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Evara_Shop.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
