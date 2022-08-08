package com.thoughtworks.training.service;

import com.thoughtworks.training.entity.Movie;
import com.thoughtworks.training.exception.MovieNotFoundException;
import com.thoughtworks.training.reoository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
    public Movie getMovieById(Integer id){
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }
    public Movie save() {
        return movieRepository.save(new Movie(1,"sad","sd",2.0));
    }
}
