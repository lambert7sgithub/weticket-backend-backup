package com.thoughtworks.training.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Screening {
    @Id
    private Integer screeningId;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnoreProperties(value = "screenings")
    private Cinema cinema;
    @JsonFormat()
    @Column(name = "start_date")
    private Date startDateTime;
    //座位总数
    private Integer seatNum;
    private Integer surplusSeats;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
