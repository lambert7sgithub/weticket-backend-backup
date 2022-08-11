package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.FoodOrderRequest;
import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.controller.mapper.FoodOrderMapper;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food-orders")
public class FoodOrderController {

    @Autowired
    FoodOrderMapper foodOrderMapper;

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping("/user/{userId}")
    public List<Map<String, Object>> findAllFoodOrdersByUserId(@PathVariable long userId, Principal principal) throws Exception {
        return foodOrderService.findAllFoodOrdersByUserId(userId,principal);
    }

    @PostMapping
    @ResponseStatus
    public FoodOrderResponse postBuyAFood(@RequestBody FoodOrderRequest foodOrderRequest, Principal principal) throws UserException {
        return foodOrderMapper.toResponse(foodOrderService.insert(foodOrderMapper.toEntity(foodOrderRequest),principal));
    }
}
