package com.thoughtworks.training.controller;

import com.thoughtworks.training.entity.Movie;
import com.thoughtworks.training.entity.MovieList;
import com.thoughtworks.training.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }
    @GetMapping("/list")
    public List<MovieList> findMovieList(){
        return movieService.findAll().stream().map(movie -> {
            return new MovieList(movie.getMovie_id(), movie.getMovie_name(), movie.getPicture(), movie.getScore());
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }
    @PostMapping
    public Movie save(){
        return movieService.save();
    }
}
