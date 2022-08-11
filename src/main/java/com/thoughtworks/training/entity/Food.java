package com.thoughtworks.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Food {
    @Id
    @Column(name = "food_id")
    private Integer id;
    private String foodName;
    private Integer inventory;
    private String picture;
    private Double price;
}
