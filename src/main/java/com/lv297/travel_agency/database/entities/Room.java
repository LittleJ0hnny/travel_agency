package com.lv297.travel_agency.database.entities;

import java.util.List;

public class Room {
    private int id;
    private String type;
    private double price;
    private int num_of_beds;
    private List<Booking> bookings;
}
