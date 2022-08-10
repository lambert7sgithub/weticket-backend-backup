package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.CinemaResponse;
import com.thoughtworks.training.entity.Cinema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CinemaMapper {

    public CinemaResponse toResponse(Cinema cinema) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        BeanUtils.copyProperties(cinema, cinemaResponse);
        return cinemaResponse;
    }

    public List<CinemaResponse> toResponse(List<Cinema> cinemas) {
        return cinemas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
