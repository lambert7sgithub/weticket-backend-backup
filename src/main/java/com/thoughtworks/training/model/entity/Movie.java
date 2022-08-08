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
    private Integer movie_id;
    private String movie_name;
    private String actor;
    private String directed_by;
    private String info;
    private String language;
    private String picture;
    private Date show_time;
    private Double money;
    private String movietype;
    private Boolean is_show;
    private Double score;
    @CreatedDate
    private Date create_time;
    @LastModifiedDate
    private Date update_time;

    public Movie(Integer movie_id, String movie_name, String picture, Double score) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.picture = picture;
        this.score = score;
    }
}

