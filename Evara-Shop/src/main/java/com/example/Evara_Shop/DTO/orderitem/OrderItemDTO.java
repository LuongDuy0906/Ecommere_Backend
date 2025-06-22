package com.example.Evara_Shop.DTO.orderitem;

import java.math.BigDecimal;

import com.example.Evara_Shop.model.OrderItem;

public class OrderItemDTO {
    private Long id;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public OrderItemDTO(OrderItem item) {
        this.id = item.getId();
        this.productName = item.getProduct().getName();
        this.quantity = item.getQuantity();
        this.price = item.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
