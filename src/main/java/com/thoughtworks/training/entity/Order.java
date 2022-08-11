package com.thoughtworks.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderform")
public class Order {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "cinema_id")
    private Integer cinemaId;
    @Column(name = "screening_id")
    private Integer screeningId;
    @Column(name = "user_id")
    private Long  userId;
    private Integer votes;
    private Boolean isUsed;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;
}
