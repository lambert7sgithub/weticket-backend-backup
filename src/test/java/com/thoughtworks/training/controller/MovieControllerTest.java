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
    void findAll() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].movie_name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].score").value(3.9));
    }

    @Test
    void findList() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].movie_name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].score").value(3.9));
    }

    @Test
    void getMovieById() throws Exception {
        Movie movie = new Movie(1, "test", "https://ts1.cn.mm.bing.net/th/", 3.9);
        Movie saveMovie = movieRepository.save(movie);
        client.perform(MockMvcRequestBuilders.get("/movie/{id}", saveMovie.getMovie_id()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.movie_name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(3.9));
    }
}
