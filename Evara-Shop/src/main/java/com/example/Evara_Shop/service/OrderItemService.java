package com.example.Evara_Shop.service;

import com.example.Evara_Shop.DTO.orderitem.OrderItemBulkCreateDTO;
import com.example.Evara_Shop.DTO.orderitem.OrderItemCreateDTO;
import com.example.Evara_Shop.DTO.orderitem.OrderItemDTO;
import com.example.Evara_Shop.builder.OrderItemBuilder;
import com.example.Evara_Shop.model.Order;
import com.example.Evara_Shop.model.OrderItem;
import com.example.Evara_Shop.model.Product;
import com.example.Evara_Shop.repository.OrderItemRepo;
import com.example.Evara_Shop.repository.OrderRepo;
import com.example.Evara_Shop.repository.ProductRepo;
import com.example.Evara_Shop.validation.ValidatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ValidatorStrategy<OrderItemCreateDTO> itemValidator;

    public List<OrderItemDTO> getAllByOrderId(Long id) {
        return SimpleServiceHelper.mapToDTOList(orderItemRepo.findByOrderId(id), OrderItemDTO::new);
    }

    public List<OrderItemDTO> createBulk(OrderItemBulkCreateDTO bulkDTO) {
        Order order = orderRepo.findById(bulkDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));

        List<OrderItem> items = bulkDTO.getItems().stream().map(dto -> {
            itemValidator.validate(dto);

            Product product = productRepo.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

            return OrderItemBuilder.fromDTO(dto, order, product);
        }).collect(Collectors.toList());

        return orderItemRepo.saveAll(items).stream()
                .map(OrderItemDTO::new)
                .collect(Collectors.toList());
    }
}
