package com.thoughtworks.training.controller.mapper;

import com.thoughtworks.training.controller.dto.SeatResponse;
import com.thoughtworks.training.entity.Seat;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SeatMapper {
    public static SeatResponse toResponse(Seat seat) {
        SeatResponse response = new SeatResponse();
        response.setX(seat.getX());
        response.setY(seat.getY());
        response.setStatus(seat.getStatus());
        return response;
    }

    public static <E extends Collection<Seat>> List<SeatResponse> toResponses(E seats) {
        return seats.stream().map(SeatMapper::toResponse).collect(Collectors.toList());
    }
}
