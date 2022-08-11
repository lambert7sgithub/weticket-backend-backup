package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.CinemaResponse;
import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.entity.Cinema;
import com.thoughtworks.training.entity.FoodOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodOrderMapper {

    public FoodOrderResponse toResponse(FoodOrder foodOrder) {
        FoodOrderResponse foodOrderResponse = new FoodOrderResponse();
        BeanUtils.copyProperties(foodOrder, foodOrderResponse);
        return foodOrderResponse;
    }

    public List<FoodOrderResponse> toResponse(List<FoodOrder> foodOrders) {
        return foodOrders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
