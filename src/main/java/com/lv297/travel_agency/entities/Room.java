package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    private int id;
    private Hotel hotel;
    private String type;
    private double price;
    private int num_of_beds;
    private List<Booking> bookings;

    public Room(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Column(name="type", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "price", nullable = false, precision = 2)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "number_of_bed", nullable = false)
    public int getNum_of_beds() {
        return num_of_beds;
    }

    public void setNum_of_beds(int num_of_beds) {
        this.num_of_beds = num_of_beds;
    }

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
                ", hotel=" + hotel +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", num_of_beds=" + num_of_beds +
                '}';
    }
}
