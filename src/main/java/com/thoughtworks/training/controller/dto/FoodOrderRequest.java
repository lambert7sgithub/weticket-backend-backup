package com.thoughtworks.training.controller.dto;

import lombok.Getter;

@Getter
public class FoodOrderRequest {
    private int foodId;
    private String foodName;
    private Integer count;
    private Double totalPrice;
    private Double price;
}
