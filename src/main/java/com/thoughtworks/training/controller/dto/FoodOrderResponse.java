package com.thoughtworks.training.controller.dto;

import lombok.Data;
@Data
public class FoodOrderResponse {
    private String id;
    private String foodName;
    private Integer count;
    private Boolean isUsed;
    private Double totalPrice;
    private Double price;
    private String createTime;
}
