package com.thoughtworks.training.controller;

import com.thoughtworks.training.model.dto.MovieListResponse;
import com.thoughtworks.training.model.entity.Movie;
import com.thoughtworks.training.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieListResponse>> findMovieList() {
        return movieService.findList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Movie save() {
        return movieService.save();
    }
}
