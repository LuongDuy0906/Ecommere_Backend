package com.example.Evara_Shop.controller;

import com.example.Evara_Shop.DTO.orderitem.OrderItemBulkCreateDTO;
import com.example.Evara_Shop.DTO.orderitem.OrderItemDTO;
import com.example.Evara_Shop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orders/{id}/items")
    public List<OrderItemDTO> getItemsByOrder(@PathVariable Long id) {
        return orderItemService.getAllByOrderId(id);
    }

    @PostMapping("/bulk")
    public List<OrderItemDTO> createBulk(@RequestBody OrderItemBulkCreateDTO dto) {
        return orderItemService.createBulk(dto);
    }
}
