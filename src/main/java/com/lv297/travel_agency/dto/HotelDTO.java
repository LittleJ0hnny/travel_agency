package com.lv297.travel_agency.dto;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;

import java.util.List;

/**
 * Created by ivan on 27.02.18.
 */
public class HotelDTO {
    private int id;
    private String name;
    private City city;
    private List<Room> rooms;
    private int numberClient;
    private double averageBookingTime;

    public HotelDTO(Hotel hotel) {
        id = hotel.getId();
        name = hotel.getName();
        city = hotel.getCity();
        rooms = hotel.getRooms();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(int numberClient) {
        this.numberClient = numberClient;
    }

    public double getAverageBookingTime() {
        return averageBookingTime;
    }

    public void setAverageBookingTime(double averageBookingTime) {
        this.averageBookingTime = averageBookingTime;
    }
}
