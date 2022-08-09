package com.thoughtworks.training.controller.dto;

import lombok.Data;

@Data
public class MovieListResponse {
    private Integer movieId;
    private String movieName;
    private String picture;
    private Double score;

    public MovieListResponse(Integer movieId, String movieName, String picture, Double score) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.picture = picture;
        this.score = score;
    }
}
