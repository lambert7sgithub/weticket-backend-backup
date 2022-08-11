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
    private String seatSituation = "充足";
    private String language;
    private double moviePrice;
}
