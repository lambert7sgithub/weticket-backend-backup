package com.thoughtworks.training.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailResponse {
    private Date date;
    private String movieName;
    private String cinema;
    private String screeningRoom;
    private Double price;
    private String movieLang;
    private String picture;
    private Integer movieLength;
}
