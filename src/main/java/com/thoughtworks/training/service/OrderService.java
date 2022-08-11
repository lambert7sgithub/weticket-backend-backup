package com.thoughtworks.training.service;


import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.OrderRepository;
import com.thoughtworks.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Resource
    private UserRepository userRepository;

    public Map<String, Object> findMessageByOrderId(String userId) {
        List<Map<String, Object>> messageByOrderId = orderRepository.findMessageByOrderId(userId);
        Map<String, Object> map = messageByOrderId.get(0);
        return messageByOrderId.get(0);
    }

    public List<Map<String, Object>> findOrdersByUserId(Integer userId, Principal principal) throws UserException {
        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        long id = user.getId();
        List<Map<String, Object>> messageOrders = orderRepository.findOrdersByUserId(id);
        return messageOrders;
    }
}
