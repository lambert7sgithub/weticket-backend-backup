package com.thoughtworks.training.repository;

import com.thoughtworks.training.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
    List<FoodOrder> findFoodOrdersByUserId(long userId);
}
