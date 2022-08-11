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
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FoodOrderService {
    @Autowired
    public FoodOrderRepository foodOrderRepository;

    @Autowired
    FoodOrderMapper foodOrderMapper;

    @Autowired
    public FoodRepository foodRepository;


    @Resource
    private UserRepository userRepository;

    public List<FoodOrderResponse> findAllFoodOrdersByUserId(Principal principal) throws Exception {
        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        List<FoodOrder> foodOrders = foodOrderRepository.findFoodOrdersByUserId(user.getId());
        foodOrders.sort(Comparator.comparing(FoodOrder::getCreateTime));
        return foodOrderMapper.toResponse(foodOrders);

    }

    public FoodOrder insert(FoodOrder foodOrder,Principal principal,Integer foodId) throws UserException {
        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName()).orElseThrow(() -> new UserException("User Not Found"));
        foodOrder.setId(String.valueOf(UUID.randomUUID()).substring(0,30));
        foodOrder.setUserId(user.getId());
        foodOrder.setCreateTime(new Date());
        foodOrder.setIsUsed(false);

        Food food = foodRepository.findById(foodId).orElseThrow(() -> new UserException("Food Not Found"));
        int inventory = food.getInventory() - 1;
        food.setInventory(inventory);
        foodRepository.save(food);
        return foodOrderRepository.save(foodOrder);
    }
}
