package com.thoughtworks.training.service;

import com.thoughtworks.training.controller.dto.MovieDetailResponse;
import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.controller.dto.SeatBookingRequest;
import com.thoughtworks.training.controller.dto.SeatResponse;
import com.thoughtworks.training.controller.mapper.ScreeningMapper;
import com.thoughtworks.training.controller.mapper.SeatMapper;
import com.thoughtworks.training.entity.Order;
import com.thoughtworks.training.entity.Screening;
import com.thoughtworks.training.entity.Seat;
import com.thoughtworks.training.entity.User;
import com.thoughtworks.training.exception.SeatException;
import com.thoughtworks.training.exception.UserException;
import com.thoughtworks.training.repository.OrderRepository;
import com.thoughtworks.training.repository.ScreeningRepository;
import com.thoughtworks.training.repository.SeatRepository;
import com.thoughtworks.training.repository.UserRepository;
import com.thoughtworks.training.utils.DateUtil;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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

    @Resource
    private OrderRepository orderRepository;

    private static final Integer UNBOOKED = 0;
    private static final Integer SINGLE_BOOKING = 1;
    private static final Integer MULTIPLE_BOOKING = 2;
    private static final Integer UNWILLING_PAIR = 3;


    private static void booking(SeatBookingRequest request, int singleFlag, User user, Screening screening)
            throws Exception {
        for (ArrayList<Integer> booking : request.getBookings()) {
            Seat res = screening.getSeats().stream().filter(
                    seat -> seat.getX().equals(booking.get(0)) && seat.getY().equals(booking.get(1))
            ).findFirst().orElseThrow(() -> new SeatException("Seat Not Found"));
            if (!res.getStatus().equals(UNBOOKED)) {
                throw new SeatException("Seat Occupied");
            } else {
                if (singleFlag == SINGLE_BOOKING) {
                    res.setStatus(SINGLE_BOOKING);
                } else {
                    res.setStatus(MULTIPLE_BOOKING);
                }
                if (Boolean.FALSE.equals(request.getWillingPair())) {
                    res.setStatus(UNWILLING_PAIR);
                }
                res.setUser(user);
                screening.getSeats().add(res);
            }
        }
    }

    @SneakyThrows
    public List<ScreeningResponse> findScreeningsByDateCinemaMovie(Date dateTime, Integer cinemaId, Integer movieId) {
        List<Screening> screenings = screeningRepository.findScreeningsByMovie_MovieIdAndCinema_CinemaIdAndStartDateTimeBeforeAndStartDateTimeAfter(movieId, cinemaId, dateUtil.getFutureDate(1, dateTime), dateTime);
        screenings.sort(Comparator.comparing(Screening::getStartDateTime));
        return screeningMapper.toResponse(screenings);
    }

    @SneakyThrows
    public List<ScreeningResponse> findScreeningsByDateCinemaMovie(Integer cinemaId, Integer movieId) {
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

    @Transactional
    public ResponseEntity<Void> bookingSeats(Integer screeningId, SeatBookingRequest request, Principal principal)
            throws Exception {
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
                .orElseThrow(() -> new SeatException("Screening Not Found"));
        initScreeningSeat(screening);
        booking(request, singleFlag, user, screening);
        order(screeningId, request, user, screening);
        screeningRepository.save(screening);
        return ResponseEntity.ok().build();
    }

    private void order(Integer screeningId, SeatBookingRequest request, User user, Screening screening) {
        Order order = new Order();
        order.setOrderId(String.valueOf(UUID.randomUUID().getMostSignificantBits()));
        order.setScreeningId(screeningId);
        order.setCinemaId(screening.getScreeningId());
        order.setIsUsed(false);
        order.setUserId(user.getId());
        order.setMovieId(screening.getMovie().getMovieId());
        order.setCreateTime(new Date());
        order.setVotes(request.getBookings().size());
        orderRepository.save(order);
    }

    public ResponseEntity<List<SeatResponse>> getSeatStatus(Integer screeningId) throws Exception {
        Screening screening = screeningRepository.findById(screeningId)
                .orElseThrow(() -> new SeatException("Screening Not Found"));
        initScreeningSeat(screening);
        screeningRepository.save(screening);

        return new ResponseEntity<>(SeatMapper.toResponses(screening.getSeats()), HttpStatus.OK);
    }

    public ResponseEntity<MovieDetailResponse> getMovieDetail(Integer screeningId) throws Exception {
        MovieDetailResponse response = new MovieDetailResponse();
        Screening screening = screeningRepository.findById(screeningId).orElseThrow(() -> new SeatException("Screening Not Found"));
        response.setCinema(screening.getCinema().getCinemaName());
        response.setMovieLang(screening.getMovie().getLanguage());
        response.setDate(screening.getStartDateTime());
        response.setPrice(screening.getMovie().getMoney());
        response.setPicture(screening.getMovie().getPicture());
        response.setMovieName(screening.getMovie().getMovieName());
        response.setScreeningRoom(screening.getCinema().getCinemaName() + screening.getScreeningId());
        response.setMovieLength(screening.getMovie().getLength());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
