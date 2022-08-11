package com.thoughtworks.training.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food_order")
public class FoodOrder {
    @Id
    @Column(name = "food_order_id")
    private String id;
    @Column(name = "food_id")
    private Integer foodId;
    @Column(name = "food_name")
    private String foodName;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "count")
    private Integer count;
    @Column(name = "is_used")
    private Boolean isUsed;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "price")
    private Double price;
    @JsonFormat()
    private Date createTime;
}
