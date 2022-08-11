package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.controller.mapper.FoodOrderMapper;
import com.thoughtworks.training.entity.FoodOrder;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.FoodOrderRepository;
import com.thoughtworks.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class FoodOrderService {
    @Autowired
    public FoodOrderRepository foodOrderRepository;

    @Autowired
    FoodOrderMapper foodOrderMapper;
    @Resource
    private UserRepository userRepository;

    public List<Map<String, Object>> findAllFoodOrdersByUserId(Principal principal, Integer id) throws Exception {
        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        long userId = user.getId();
        List<Map<String, Object>> mapList = foodOrderRepository.findFoodOrdersByUserId(userId);
        return mapList;

    }
}
