package com.example.Evara_Shop.chain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Evara_Shop.chain.AbstractDeleteHandler;
import com.example.Evara_Shop.model.User;
import com.example.Evara_Shop.repository.OrderRepo;

@Component
public class OrderDependencyCheckHandler extends AbstractDeleteHandler<User> {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    protected void check(User user) {
        if (orderRepo.existsByUserId(user.getId())) {
            throw new RuntimeException("Không thể xóa user đã có đơn hàng.");
        }
    }
}
