package com.example.Evara_Shop.DTO.orderitem;

import java.util.List;

public class OrderItemBulkCreateDTO {
    private Long orderId;
    private List<OrderItemCreateDTO> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItemCreateDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemCreateDTO> items) {
        this.items = items;
    }
}
