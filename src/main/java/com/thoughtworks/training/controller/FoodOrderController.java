package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/food-orders")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping
    public List<FoodOrderResponse> findAllFoodOrdersByUserId(Principal principal) throws Exception {
        return foodOrderService.findAllFoodOrdersByUserId(principal);
    }


}
