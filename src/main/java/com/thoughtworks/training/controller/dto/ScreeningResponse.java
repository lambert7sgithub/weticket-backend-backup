package com.thoughtworks.training.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ScreeningResponse {
    private int screeningId;
    private int movieId;
    private int auditoriumId;
    private String auditoriumName;
    private Date startDate;
    private Date endTime;
    private double seatSituation;
    private String language;
    private double moviePrice;
}
