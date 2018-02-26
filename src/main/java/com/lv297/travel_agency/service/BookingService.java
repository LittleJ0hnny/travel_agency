package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Booking;

import java.util.List;

public interface BookingService {
    Booking updateBooking(Booking booking);
    void deleteBooking(Booking booking);
    void saveBooking(Booking booking);
    Booking getBookingById(int id);
    List<Booking> getAllBookings();
}
