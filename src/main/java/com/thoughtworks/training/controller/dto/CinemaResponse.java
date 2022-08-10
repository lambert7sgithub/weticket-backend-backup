package com.thoughtworks.training.controller.dto;

import lombok.Data;

@Data
public class CinemaResponse {
    private int cinemaId;
    private String cinemaName;
    private String location;
}
