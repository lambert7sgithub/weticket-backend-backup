package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.CinemaResponse;
import com.thoughtworks.training.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<CinemaResponse> findAllCinema() {
        return cinemaService.findAllCinemas();
    }
}

