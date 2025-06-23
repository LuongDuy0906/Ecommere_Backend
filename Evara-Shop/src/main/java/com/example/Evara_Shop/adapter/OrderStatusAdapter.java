package com.example.Evara_Shop.adapter;

import com.example.Evara_Shop.enums.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusAdapter {

    // Từ String → Enum (cho POST / PUT)
    public OrderStatus adapt(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Trạng thái không được để trống.");
        }
        try {
            return OrderStatus.valueOf(status.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Trạng thái không hợp lệ: " + status);
        }
    }

    // Từ Enum → String (cho GET)
    public static String toDisplay(OrderStatus status) {
        if (status == null)
            return "Không xác định";
        return switch (status) {
            case PENDING -> "Đang chờ xử lý";
            case PROCESSING -> "Đang xử lý";
            case COMPLETED -> "Hoàn thành";
            case CANCELLED -> "Đã hủy";
        };
    }
}
