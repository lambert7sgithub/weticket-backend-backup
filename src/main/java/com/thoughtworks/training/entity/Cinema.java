package com.thoughtworks.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cinema {
    @Id
    private int cinemaId;
    private String cinemaName;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "screeningId")
    private List<Screening> screenings;
}
