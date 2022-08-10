package com.thoughtworks.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Screening {
    @Id
    private int screeningId;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    private Date startDate;
    //座位总数
    private int seatNum;
    private int surplusSeats;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
