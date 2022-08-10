package com.thoughtworks.training.controller;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.dto.SeatBookingRequest;
import com.thoughtworks.training.controller.dto.SeatResponse;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.service.ScreeningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {
    @Resource
    private ScreeningService screeningService;

    @GetMapping("/cinema/{cinemaId}/movie/{movieId}/{date}")
    public List<ScreeningResponse> findDateScreeningByDate(@PathVariable("date") String dateString,
                                                           @PathVariable("cinemaId") Integer cinemaid,
                                                           @PathVariable("movieId") Integer movieid) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
        return screeningService.findScreeningsByDateCinemaMovie(date, cinemaid, movieid);
    }

    @GetMapping("/cinema/{cinemaId}/movie/{movieId}")
    public List<ScreeningResponse> findDateScreening(@PathVariable("cinemaId") Integer cinemaid,
                                                     @PathVariable("movieId") Integer movieid) {
        return screeningService.findScreeningsByDateCinemaMovie(cinemaid, movieid);
    }

    @PostMapping("/{screeningId}")
    public ResponseEntity<Void> bookingSeat(
            @PathVariable Integer screeningId,
            @RequestBody SeatBookingRequest request,
            Principal principal
    ) throws UserException {
        return screeningService.bookingSeats(screeningId, request, principal);
    }

    @GetMapping("/{screeningId}")
    public ResponseEntity<List<SeatResponse>> bookingSeat(
            @PathVariable Integer screeningId
    ) throws UserException {
        return screeningService.getSeatStatus(screeningId);
    }

}
