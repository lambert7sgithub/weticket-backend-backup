package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.FoodOrderRequest;
import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.controller.mapper.FoodOrderMapper;
import com.thoughtworks.training.entity.FoodOrder;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/food-orders")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @Autowired
    FoodOrderMapper foodOrderMapper;

    @GetMapping
    public List<FoodOrderResponse> findAllFoodOrdersByUserId(Principal principal) throws Exception {
        return foodOrderService.findAllFoodOrdersByUserId(principal);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FoodOrderResponse createEmployee(@RequestBody FoodOrderRequest foodOrderRequest,Principal principal) throws UserException {
        return foodOrderMapper.toResponse(foodOrderService.insert(foodOrderMapper.toEntity(foodOrderRequest),principal,foodOrderRequest.getFoodId()));
    }
}
