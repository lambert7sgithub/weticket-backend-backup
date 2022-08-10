package com.thoughtworks.training.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScreeningResponse {
    private int screeningId;
    private int movieId;
    private int auditoriumId;
    private String auditoriumName;
    private String startDate;
    private String endTime;
    private double seatSituation;
    private String language;
    private double moviePrice;
}
