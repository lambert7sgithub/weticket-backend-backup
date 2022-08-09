package com.thoughtworks.training.service;

import com.thoughtworks.training.model.dto.MovieListResponse;
import com.thoughtworks.training.model.entity.Movie;
import com.thoughtworks.training.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MovieServiceTest {
    @InjectMocks
    MovieService movieService;
    @Mock
    private MovieRepository stubMovieRepository;


    @Test
    void findMovieList() {
        Movie movie1 = new Movie(1, "sad", "sd", 2.0);
        ArrayList<Movie> movieLists = new ArrayList<>();
        movieLists.add(movie1);
        given(stubMovieRepository.findAll()).willReturn(movieLists);
        ResponseEntity<List<Movie>> result = movieService.findAll();
        assertThat(result.getBody(), hasSize(1));
        assertThat(result.getBody().get(0), equalTo(movie1));
    }

    @Test
    void findList() {
        Movie movie1 = new Movie(1, "sad", "sd", 2.0);
        ArrayList<Movie> movieLists = new ArrayList<>();
        movieLists.add(movie1);
        given(stubMovieRepository.findAll()).willReturn(movieLists);
        ResponseEntity<List<MovieListResponse>> result = movieService.findList();
        assertThat(result.getBody(), hasSize(1));
        assertThat(result.getBody().get(0).getMovie_name(), equalTo(movie1.getMovie_name()));
    }

    @Test
    void getMovieById() {
        Movie movie1 = new Movie(1, "sad", "sd", 2.0);
        given(stubMovieRepository.findById(1)).willReturn(Optional.of(movie1));
        ResponseEntity<Movie> result = movieService.getMovieById(1);
        assertThat(result.getBody(), equalTo(movie1));
    }
}
