package com.thoughtworks.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema {
    @Id
    private Integer cinemaId;
    private String cinemaName;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "screeningId")
    @JsonIgnoreProperties(value = "cinema")
    private List<Screening> screenings;
}
