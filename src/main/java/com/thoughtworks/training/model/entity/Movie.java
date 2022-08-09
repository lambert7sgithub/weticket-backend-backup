package com.thoughtworks.training.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Movie {
    @Id
    private Integer movieId;
    private String movieName;
    private String actor;
    private String directedBy;
    private String info;
    private String language;
    private String picture;
    private Date showTime;
    private Double money;
    private String movieType;
    private Boolean isShow;
    private Double score;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;

    public Movie(Integer movieId, String movieName, String picture, Double score) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.picture = picture;
        this.score = score;
    }
}

