package com.lv297.travel_agency.database.entities;

import java.util.Date;

public class Booking {
    private int id;
    private int clientId;
    private int hotelId;
    private int roomId;
    private Date bookingFrom;
    private Date bookingTo;

    public Booking(){}

    public Booking(int id, int clientId, int hotelId, int roomId, Date bookingFrom, Date bookingTo) {
        this.id = id;
        this.clientId = clientId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
