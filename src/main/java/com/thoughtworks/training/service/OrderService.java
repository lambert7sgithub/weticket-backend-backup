package com.thoughtworks.training.service;


import com.thoughtworks.training.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Map<String, Object> findMessageByOrderId(String orderId) {
        List<Map<String, Object>> messageByOrderId = orderRepository.findMessageByOrderId(orderId);
        Map<String, Object> map = messageByOrderId.get(0);
        return messageByOrderId.get(0);
    }
}
