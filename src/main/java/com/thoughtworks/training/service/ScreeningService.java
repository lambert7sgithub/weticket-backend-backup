package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.dto.SeatBookingRequest;
import com.thoughtworks.training.controller.dto.SeatResponse;
import com.thoughtworks.training.controller.mapper.ScreeningMapper;
import com.thoughtworks.training.controller.mapper.SeatMapper;
import com.thoughtworks.training.entity.Screening;
import com.thoughtworks.training.entity.Seat;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.ScreeningRepository;
import com.thoughtworks.training.repository.SeatRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.utils.DateUtil;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@Service
public class ScreeningService {
    DateUtil dateUtil = new DateUtil();
    @Resource
    private ScreeningRepository screeningRepository;
    @Resource
    private ScreeningMapper screeningMapper;
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

    @SneakyThrows
    public List<ScreeningResponse> findAllScreenings(Date dateTime, Integer cinemaId, Integer movieId) {
        List<Screening> screenings = screeningRepository.findScreeningsByMovie_MovieIdAndCinema_CinemaIdAndStartDateTimeBeforeAndStartDateTimeAfter(movieId, cinemaId, dateUtil.getFutureDate(1, dateTime), dateTime);
        screenings.sort(Comparator.comparing(Screening::getStartDateTime));
        return screeningMapper.toResponse(screenings);
    }

    @SneakyThrows
    public List<ScreeningResponse> findAllScreenings(Integer cinemaId, Integer movieId) {
        Date date = new Date();
        List<Screening> screenings = screeningRepository.findScreeningsByMovie_MovieIdAndCinema_CinemaIdAndStartDateTimeBeforeAndStartDateTimeAfter(movieId, cinemaId, dateUtil.getFutureDate(1, date), date);
        screenings.sort(Comparator.comparing(Screening::getStartDateTime));
        return screeningMapper.toResponse(screenings);
    }

    private void initScreeningSeat(Screening screening) {
        if (screening.getSeats() == null || screening.getSeats().isEmpty()) {
            Set<Seat> seats = new HashSet<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    seats.add(new Seat(UUID.randomUUID(), 0, i, j, null));
                }
            }
            screening.setSeats(seats);
            seatRepository.saveAll(screening.getSeats());
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
        screeningRepository.save(screening);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<SeatResponse>> getSeatStatus(Integer screeningId) throws UserException {
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new UserException("Screening Not Found Exception"));
        initScreeningSeat(screening);
        screeningRepository.save(screening);

        return new ResponseEntity<>(SeatMapper.toResponses(screening.getSeats()), HttpStatus.OK);
    }
}
