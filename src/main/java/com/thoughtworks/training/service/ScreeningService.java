package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.mapper.ScreeningMapper;
import com.thoughtworks.training.entity.Screening;
import com.thoughtworks.training.repository.ScreeningRepository;
import com.thoughtworks.training.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    DateUtil dateUtil = new DateUtil();

    @Autowired
    private ScreeningMapper screeningMapper;


    public List<ScreeningResponse> findAllScreenings(Date dateTime, Integer cinemaId, Integer movieId) {
        List<Screening> screenings = screeningRepository.findAll()
                .stream()
                .filter(screening -> {
                            try {
                                return (Objects.equals(screening.getCinema().getCinemaId(), cinemaId))
                                        && (screening.getStartDateTime().after(dateTime))
                                        && (screening.getStartDateTime().before(dateUtil.getFutureDate(1, dateTime)))
                                        && (Objects.equals(screening.getMovie().getMovieId(), movieId));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .collect(Collectors.toList());
        return screeningMapper.toResponse(screenings);
    }

    public List<ScreeningResponse> findAllScreenings(Integer cinemaId, Integer movieId) {
        Date date = new Date();
        List<Screening> screenings = screeningRepository.findAll()
                .stream()
                .filter(screening -> {
                            try {
                                return (Objects.equals(screening.getCinema().getCinemaId(), cinemaId))
                                        && (screening.getStartDateTime().after(date))
                                        && (screening.getStartDateTime().before(dateUtil.getFutureDate(1, date)))
                                        && (Objects.equals(screening.getMovie().getMovieId(), movieId));
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .collect(Collectors.toList());
        return screeningMapper.toResponse(screenings);
    }
}
