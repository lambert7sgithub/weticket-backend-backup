package com.thoughtworks.training.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class SeatBookingRequest {
    List<ArrayList<Integer>> bookings;

    private Boolean willingPair;

    public Boolean getWillingPair() {
        return willingPair;
    }

    public void setWillingPair(Boolean willingPair) {
        this.willingPair = willingPair;
    }

    public List<ArrayList<Integer>> getBookings() {
        return bookings;
    }

    public void setBookings(List<ArrayList<Integer>> bookings) {
        this.bookings = bookings;
    }
}
