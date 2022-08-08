package com.thoughtworks.training.service;

import com.thoughtworks.training.entity.Movie;
import com.thoughtworks.training.reoository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MovieServiceTest {
    @InjectMocks
    MovieService movieService;
    @Mock
    private MovieRepository stubMovieRepository;


    @Test
    void findMovieList() {
        Movie movie1 = new Movie(1,"sad","sd",2.0);
        ArrayList<Movie> movieLists = new ArrayList<>();
        movieLists.add(movie1);
        given(stubMovieRepository.findAll()).willReturn(movieLists);
        List<Movie> result = movieService.findAll();

    }
}