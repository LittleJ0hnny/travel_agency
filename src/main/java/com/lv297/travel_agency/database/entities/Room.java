package com.lv297.travel_agency.database.entities;

import java.util.List;

public class Room {
    private int id;
    private String type;
    private double price;
    private int num_of_beds;
    private List<Booking> bookings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", bookings=" + bookings +
                '}';
    }
}
