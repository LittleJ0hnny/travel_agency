package com.lv297.travel_agency.database.entities;

import java.util.List;

public class Room {
    private int id;
    private int hotelId;
    private String type;
    private double price;
    private int num_of_beds;
    private List<Booking> bookings;

    public Room(){}

    public Room(int id, int hotelId, String type, double price, int num_of_beds, List<Booking> bookings) {
        this.id = id;
        this.hotelId = hotelId;
        this.type = type;
        this.price = price;
        this.num_of_beds = num_of_beds;
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum_of_beds() {
        return num_of_beds;
    }

    public void setNum_of_beds(int num_of_beds) {
        this.num_of_beds = num_of_beds;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", num_of_beds=" + num_of_beds +
                '}';
    }
}
