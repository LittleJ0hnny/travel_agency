package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {
    private int id;
    private Client client;
    private Hotel hotel;
    private Room room;
    private LocalDate bookingFrom;
    private LocalDate bookingTo;

    public Booking() {
    }

    public Booking(int id, Client client, Hotel hotel, Room room, LocalDate bookingFrom, LocalDate bookingTo) {
        this.id = id;
        this.client = client;
        this.hotel = hotel;
        this.room = room;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name = "booking_from", nullable = false)
    public LocalDate getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(LocalDate bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    @Column(name = "booking_to", nullable = false)
    public LocalDate getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(LocalDate bookingTo) {
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
