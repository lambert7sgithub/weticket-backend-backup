package com.thoughtworks.training.entity;

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
<<<<<<<< HEAD:src/main/java/com/thoughtworks/training/model/entity/Movie.java
========
    private Integer length;
>>>>>>>> dev:src/main/java/com/thoughtworks/training/entity/Movie.java

    public Movie(Integer movieId, String movieName, String picture, Double score) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.picture = picture;
        this.score = score;
    }
}

