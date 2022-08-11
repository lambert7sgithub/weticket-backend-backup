package com.thoughtworks.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SocialForm {
    @Id
    private String id;
    private String name;
    private String gender;
    private String phone;

    private String cinemas;
    private String films;

    private Long userId;
}
