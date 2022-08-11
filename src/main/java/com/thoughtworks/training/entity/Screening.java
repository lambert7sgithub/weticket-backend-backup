package com.thoughtworks.training.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Screening {
    @Id
    private Integer ScreeningId;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnoreProperties(value = "screenings")
    private Cinema cinema;
    @JsonFormat()
    @Column(name = "start_date")
    private Date startDateTime;
    private Integer seatNum;
    private Integer surplusSeats;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @OneToMany
    @JoinTable(
            name = "t_screening_seats",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private Set<Seat> seats;
}
