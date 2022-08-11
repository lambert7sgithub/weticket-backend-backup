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
public class FoodOrder {
    @Id
    @Column(name = "order_id")
    private String id;
    @JoinColumn(name = "user_id")
    private Long userId;
    private Integer count;
    private Boolean isUsed;
    @CreatedDate
    private Date createTime;
}
