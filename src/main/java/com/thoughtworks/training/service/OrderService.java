package com.thoughtworks.training.service;


import com.thoughtworks.training.controller.dto.OrderResponse;
import com.thoughtworks.training.entity.Order;
import com.thoughtworks.training.repository.OrderRepository;
import org.hibernate.boot.model.source.spi.Orderable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findMessageByOrderId(String orderId) {
       return orderRepository.findMessageByOrderId(orderId);
    }
}
