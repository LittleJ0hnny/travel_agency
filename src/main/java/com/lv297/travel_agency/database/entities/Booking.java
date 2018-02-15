package com.lv297.travel_agency.database.entities;

import java.util.Date;

public class Booking {
    private int id;
    private Date bookingFrom;
    private Date bookingTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public Date getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(Date bookingTo) {
        this.bookingTo = bookingTo;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingFrom=" + bookingFrom +
                ", bookingTo=" + bookingTo +
                '}';
    }
}
