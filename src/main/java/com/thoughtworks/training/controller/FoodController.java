package com.thoughtworks.training.controller;

import com.thoughtworks.training.entity.Food;
import com.thoughtworks.training.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/{page}/{size}")
    public Page<Food> findAllFood(@PathVariable("page") Integer page,
                                  @PathVariable("size") Integer size) {
        return foodService.findAllFoodByPage(PageRequest.of(page, size));
    }
}
