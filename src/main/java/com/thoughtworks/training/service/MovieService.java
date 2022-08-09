package com.thoughtworks.training.service;

import com.thoughtworks.training.exception.MovieNotFoundException;
import com.thoughtworks.training.model.dto.MovieListResponse;
import com.thoughtworks.training.model.entity.Movie;
import com.thoughtworks.training.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(movieRepository.findAll());
    }

    public ResponseEntity<List<MovieListResponse>> findList() {
        return new ResponseEntity<>(
                movieRepository.findAll().stream().map(movie -> {
                    return new MovieListResponse(movie.getMovieId(), movie.getMovieName(), movie.getPicture(), movie.getScore());
                }).collect(Collectors.toList()), HttpStatus.OK
        );
    }

    public ResponseEntity<Movie> getMovieById(Integer id) {
        return ResponseEntity.ok(movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new));
    }

    //TODO:mock data
    public Movie save() {
        return movieRepository.save(new Movie(1, "sad", "sd", 2.0));
    }
}
