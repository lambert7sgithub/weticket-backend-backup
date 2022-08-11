package com.thoughtworks.training.service;

import com.thoughtworks.training.entity.Food;
import com.thoughtworks.training.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public Page<Food> findAllFoodByPage(PageRequest pageRequest) {
        return foodRepository.getByOrderById(pageRequest);
    }
}
