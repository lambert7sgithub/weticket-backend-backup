package com.thoughtworks.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MovieList {
    private Integer movie_id;
    private String movie_name;
    private String picture;
    private Double score;

    public MovieList(Integer movie_id, String movie_name, String picture, Double score) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.picture = picture;
        this.score = score;
    }
}
