package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.CinemaResponse;
import com.thoughtworks.training.controller.mapper.CinemaMapper;
import com.thoughtworks.training.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    CinemaMapper cinemaMapper;

    public List<CinemaResponse> findAllCinemas() {
        return cinemaMapper.toResponse(cinemaRepository.findAll());
    }
}
