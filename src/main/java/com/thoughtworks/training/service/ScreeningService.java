package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.mapper.ScreeningMapper;
import com.thoughtworks.training.entity.Screening;
import com.thoughtworks.training.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private ScreeningMapper screeningMapper;


    public List<ScreeningResponse> findAllScreenings(Date date, Integer cinemaId, Integer movieId) {
        List<Screening> screenings = screeningRepository.findAll()
                .stream()
                .filter(screening -> (screening.getCinema().getCinemaId() == cinemaId)
                        && (screening.getStartDate().after(date))
                        && (Objects.equals(screening.getMovie().getMovieId(), movieId))
                )
                .collect(Collectors.toList());
        return screeningMapper.toResponse(screenings);
    }

    public List<ScreeningResponse> findAllScreenings(Integer cinemaId, Integer movieId) {
        Date date = new Date(System.currentTimeMillis());
        List<Screening> screenings = screeningRepository.findAll()
                .stream()
                .filter(screening -> (screening.getCinema().getCinemaId() == cinemaId)
                        && (screening.getStartDate().after(date))
                        && (Objects.equals(screening.getMovie().getMovieId(), movieId))
                )
                .collect(Collectors.toList());
        return screeningMapper.toResponse(screenings);
    }
}
