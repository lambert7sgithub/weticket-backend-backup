package com.thoughtworks.training.controller.dto;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private String orderId;
    private String movieName;
    private String imageUrl;
    private String language;
    private Integer length;
    private String cinemaName;
    private Integer votes;
    private Double unitPrice;
    private Double allPrice;
    private Boolean isUsed;
    private Date startDate;
}
