package com.thoughtworks.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
    private String foodName;
    @Column(name = "user_id")
    private Long userId;
    private Integer count;
    private Boolean isUsed;
    private Double totalPrice;
    private Double price;
    @CreatedDate
    private Date createTime;
}
