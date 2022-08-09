package com.thoughtworks.training.controller;

import com.thoughtworks.training.model.entity.Movie;
import com.thoughtworks.training.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {
    @Autowired
    private MockMvc client;
    @Autowired
    private MovieRepository movieRepository;
    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
    }

    @Test
    void should_return_all_movie_when_call_find_all_api_given_the_service_is_up() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].movieName").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].score").value(3.9));
    }

    @Test
    void should_return_all_movie_list_when_call_find_all_movies_list_api_given_the_service_is_up() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].movieName").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].score").value(3.9));
    }

    @Test
    void should_return_movie_by_id_when_call_get_by_id_given_the_service_is_up() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        Movie saveMovie = movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie/{id}", saveMovie.getMovieId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movieName").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(3.9));
    }
}
