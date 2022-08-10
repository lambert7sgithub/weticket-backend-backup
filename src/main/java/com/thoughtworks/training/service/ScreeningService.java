package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.dto.SeatBookingRequest;
import com.thoughtworks.training.controller.mapper.ScreeningMapper;
import com.thoughtworks.training.entity.Screening;
import com.thoughtworks.training.entity.Seat;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.ScreeningRepository;
import com.thoughtworks.training.repository.SeatRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.utils.DateUtil;
import com.thoughtworks.training.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ScreeningService {
    DateUtil dateUtil = new DateUtil();
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ScreeningMapper screeningMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserRepository userRepository;
    @Resource
    private SeatRepository seatRepository;

    private static void booking(SeatBookingRequest request, int singleFlag, User user, Screening screening)
            throws UserException {
        for (ArrayList<Integer> booking : request.getBookings()) {
            Seat res = screening.getSeats().stream().filter(
                    seat -> seat.getX().equals(booking.get(0)) && seat.getY().equals(booking.get(1))
            ).findFirst().orElseThrow(() -> new UserException("Seat Not Found"));
            if (res.getStatus() != 0) {
                throw new UserException("Seat Occupied");
            } else {
                if (singleFlag == 1) {
                    res.setStatus(1);
                    res.setUser(user);
                } else {
                    res.setStatus(2);
                    res.setUser(user);
                }
                screening.getSeats().add(res);
            }
        }
    }

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

    private static void initScreeningSeat(Screening screening) {
        if (screening.getSeats().isEmpty()) {
            Set<Seat> seats = new HashSet<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    seats.add(new Seat(UUID.randomUUID(), 0, i, j, null));
                }
            }
            screening.setSeats(seats);
        }
    }

    public ResponseEntity<Void> bookingSeats(Integer screeningId, SeatBookingRequest request, Principal principal)
            throws UserException {
        int singleFlag;
        if (request.getBookings().size() == 1) {
            singleFlag = 1;
        } else if (request.getBookings().size() > 1) {
            singleFlag = 2;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsernameOrEmail(principal.getName(), principal.getName())
                .orElseThrow(() -> new UserException("User Not Found"));
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new UserException("Screening Not Found"));
        initScreeningSeat(screening);
        booking(request, singleFlag, user, screening);
        seatRepository.saveAll(screening.getSeats());
        screeningRepository.save(screening);
        return ResponseEntity.ok().build();
    }
}
