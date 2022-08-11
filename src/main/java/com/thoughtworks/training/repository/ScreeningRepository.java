package com.thoughtworks.training.repository;

import com.thoughtworks.training.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findScreeningsByMovie_MovieIdAndCinema_CinemaIdAndStartDateTimeBeforeAndStartDateTimeAfter(Integer movieId, Integer cinemaId, Date futureDate, Date nowDate);

}
