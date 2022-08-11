package com.thoughtworks.training.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialFormResponse {
    private Integer id;
    private String name;
    private String gender;
    private String phone;

    private String cinemas;
    private String films;
}
