package com.thoughtworks.training.repository;

import com.thoughtworks.training.controller.dto.OrderResponse;
import com.thoughtworks.training.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(nativeQuery = true,value="select o.order_id,m.movie_name,m.picture,m.language,m.length,c.cinema_name,o.votes,m.money,m.money*votes,o.is_used,s.start_date from order o join movie m using(movie_id) join cinema c using(cinema_id) join screening s using (screening_id)")
    Order findMessageByOrderId(String orderId);
}
