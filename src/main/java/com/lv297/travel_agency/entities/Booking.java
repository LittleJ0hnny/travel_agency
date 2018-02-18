package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.util.Date;

@Cacheable
@Entity
@Table(name = "booking")
public class Booking {
    private int id;
    private Client client;
    private Hotel hotel;
    private Room room;
    private Date bookingFrom;
    private Date bookingTo;

    public Booking(){}

    public Booking(int id, Client client, Hotel hotel, Room room, Date bookingFrom, Date bookingTo) {
        this.id = id;
        this.client = client;
        this.hotel = hotel;
        this.room = room;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name = "booking_from", nullable = false)
    public Date getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    @Column(name = "booking_to", nullable = false)
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
