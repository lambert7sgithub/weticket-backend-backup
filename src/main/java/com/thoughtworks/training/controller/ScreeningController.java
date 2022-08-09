package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/{cinemaId}/{movieId}/date")
    public List<ScreeningResponse> findDateScreeningByDate(@RequestBody Date date,
                                                           @PathVariable("cinemaId") Integer cinemaid,
                                                           @PathVariable("movieId") Integer movieid) {
        return screeningService.findAllScreenings(date, cinemaid, movieid);
    }

    @GetMapping("/{cinemaId}/{movieId}")
    public List<ScreeningResponse> findDateScreening(@PathVariable("cinemaId") Integer cinemaid,
                                                     @PathVariable("movieId") Integer movieid) {
        return screeningService.findAllScreenings(cinemaid, movieid);
    }

}
