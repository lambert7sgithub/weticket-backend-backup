package com.thoughtworks.training.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @JsonFormat()
    private Date startDateTime;
    //座位总数
    private int seatNum;
    private int surplusSeats;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
