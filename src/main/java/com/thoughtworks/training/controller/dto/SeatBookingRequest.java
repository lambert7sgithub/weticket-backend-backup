package com.thoughtworks.training.controller.dto;

import java.util.ArrayList;

public class SeatBookingRequest {
    ArrayList<ArrayList<Integer>> bookings;

    public ArrayList<ArrayList<Integer>> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<ArrayList<Integer>> bookings) {
        this.bookings = bookings;
    }
}
