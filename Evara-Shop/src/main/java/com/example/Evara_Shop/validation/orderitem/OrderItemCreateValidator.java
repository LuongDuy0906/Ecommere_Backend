package com.example.Evara_Shop.validation.orderitem;

import org.springframework.stereotype.Component;

import com.example.Evara_Shop.DTO.orderitem.OrderItemCreateDTO;
import com.example.Evara_Shop.validation.ValidatorStrategy;

@Component
public class OrderItemCreateValidator implements ValidatorStrategy<OrderItemCreateDTO> {
    public void validate(OrderItemCreateDTO dto) {
        if (dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Số lượng phải lớn hơn 0");
        }
        if (dto.getProductId() == null) {
            throw new IllegalArgumentException("Thiếu orderId hoặc productId");
        }
    }
}
