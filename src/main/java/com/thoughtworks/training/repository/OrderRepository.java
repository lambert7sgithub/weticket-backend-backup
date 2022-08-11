package com.thoughtworks.training.repository;

import com.thoughtworks.training.controller.dto.OrderResponse;
import com.thoughtworks.training.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(nativeQuery = true,value="select o.order_id as orderId,m.movie_name as movieName,m.picture as imageUrl,m.language as language,m.length as length,c.cinema_name as cinemaName,o.votes as votes,m.money as unitPrice,m.money*o.votes as allPrice,o.is_used as isUsed,s.start_date as startDate from orderform o join movie m on m.movie_id=o.movie_id join cinema c on c.cinema_id=o.cinema_id join screening s on s.screening_id=o.screening_id where 1=1 and o.order_id =:orderId")
    List<Map<String,Object>> findMessageByOrderId(String orderId);

    @Query(nativeQuery = true,value="select o.order_id as orderId,m.movie_name as movieName,m.picture as imageUrl,m.language as language,c.cinema_name as cinemaName,o.votes as votes,m.money*o.votes as allPrice,s.start_date as startDate from orderform o join movie m on m.movie_id=o.movie_id join cinema c on c.cinema_id=o.cinema_id join screening s on s.screening_id=o.screening_id where 1=1 and o.order_id =:userId")
    List<Map<String, Object>> findOrdersByUserId(Integer userId);
}
