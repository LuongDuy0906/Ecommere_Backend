package com.example.Evara_Shop.builder;

import java.math.BigDecimal;

import com.example.Evara_Shop.DTO.orderitem.OrderItemCreateDTO;
import com.example.Evara_Shop.model.Order;
import com.example.Evara_Shop.model.OrderItem;
import com.example.Evara_Shop.model.Product;

public class OrderItemBuilder {
    public static OrderItem fromDTO(OrderItemCreateDTO dto, Order order, Product product) {
        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(dto.getQuantity());
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(dto.getQuantity()));
        item.setPrice(totalPrice);

        return item; // lấy theo giá thời điểm đặt hàng
    }
}
