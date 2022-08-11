package com.thoughtworks.training.controller.mapper;
import com.thoughtworks.training.controller.dto.FoodOrderRequest;
import com.thoughtworks.training.controller.dto.FoodOrderResponse;
import com.thoughtworks.training.entity.FoodOrder;
import com.thoughtworks.training.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodOrderMapper {

    DateUtil dateUtil = new DateUtil();

    public FoodOrderResponse toResponse(FoodOrder foodOrder) {
        FoodOrderResponse foodOrderResponse = new FoodOrderResponse();
        BeanUtils.copyProperties(foodOrder, foodOrderResponse);
        foodOrderResponse.setCreateTime(dateUtil.getDateString(foodOrder.getCreateTime()));
        return foodOrderResponse;
    }

    public List<FoodOrderResponse> toResponse(List<FoodOrder> foodOrders) {
        return foodOrders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public FoodOrder toEntity(FoodOrderRequest foodOrderRequest){
        FoodOrder foodOrder = new FoodOrder();
        BeanUtils.copyProperties(foodOrderRequest, foodOrder);
        return foodOrder;
    }
}
