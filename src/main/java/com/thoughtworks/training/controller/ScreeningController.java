package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/cinema/{cinemaId}/movie/{movieId}/{date}")
    public List<ScreeningResponse> findDateScreeningByDate(@PathVariable("date") String dateString,
                                                           @PathVariable("cinemaId") Integer cinemaid,
                                                           @PathVariable("movieId") Integer movieid) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
        return screeningService.findAllScreenings(date, cinemaid, movieid);
    }

    @GetMapping("/cinema/{cinemaId}/movie/{movieId}")
    public List<ScreeningResponse> findDateScreening(@PathVariable("cinemaId") Integer cinemaid,
                                                     @PathVariable("movieId") Integer movieid) {
        return screeningService.findAllScreenings(cinemaid, movieid);
    }

}
