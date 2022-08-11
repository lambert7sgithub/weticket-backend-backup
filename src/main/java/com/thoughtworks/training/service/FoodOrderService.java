package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.controller.mapper.FoodOrderMapper;
import com.thoughtworks.training.entity.Food;
import com.thoughtworks.training.entity.FoodOrder;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.FoodOrderRepository;
import com.thoughtworks.training.repository.FoodRepository;
import com.thoughtworks.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@Service
public class FoodOrderService {
    @Autowired
    public FoodOrderRepository foodOrderRepository;

    @Autowired
    FoodOrderMapper foodOrderMapper;

    @Autowired
    FoodRepository foodRepository;
    @Resource
    private UserRepository userRepository;

    public List<Map<String, Object>> findAllFoodOrdersByUserId( long id,Principal principal) throws Exception {
        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        long userId = user.getId();
        List<Map<String, Object>> mapList = foodOrderRepository.findFoodOrdersByUserId(userId);
        return mapList;
    }

    public FoodOrder insert(FoodOrder foodOrder,Principal principal) throws UserException {
        User user = userRepository.findByUsernameOrEmail(principal.getName(),
                principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        foodOrder.setId(String.valueOf(UUID.randomUUID()).substring(0,32));
        foodOrder.setUserId(user.getId());
        foodOrder.setCreateTime(new Date());
        foodOrder.setIsUsed(false);

        Food food = foodRepository.findById(foodOrder.getFoodId()).orElseThrow(() -> new UserException("Food Not Found"));
        int inventory = food.getInventory() - 1;
        food.setInventory(inventory);
        foodRepository.save(food);
        return foodOrderRepository.save(foodOrder);
    }
}
