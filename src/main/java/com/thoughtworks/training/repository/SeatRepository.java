package com.thoughtworks.training.repository;

import com.thoughtworks.training.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat getSeatByXAndY(Integer x, Integer y);
}
