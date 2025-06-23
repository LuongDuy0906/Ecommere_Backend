package com.example.Evara_Shop.DTO.order;

import com.example.Evara_Shop.model.Order;
import com.example.Evara_Shop.adapter.OrderStatusAdapter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private String userName;
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private String status;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.userName = order.getUser().getName();
        this.orderDate = order.getOrderDate();
        this.totalAmount = order.getTotalAmount();
        this.status = OrderStatusAdapter.toDisplay(order.getStatus());
        ;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }
}
