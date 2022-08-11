package com.thoughtworks.training.repository;

import com.thoughtworks.training.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Map;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
    @Query(nativeQuery = true,value="select f.food_order_id as foodOrderId,f.food_name as foodName,f.user_id as userId,f.count,f.is_used as isUsed,f.price,f.total_price as totalPrice,from food_order f join food on where f.user_id =:userId")
    List<Map<String, Object>> findFoodOrdersByUserId(long userId);
}
