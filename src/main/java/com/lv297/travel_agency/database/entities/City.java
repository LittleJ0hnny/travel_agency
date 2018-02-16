package com.lv297.travel_agency.database.entities;

import java.util.List;

public class City {
    private int id;
    private int countryId;
    private String name;
    private List<Hotel> hotels;

    public City() {

    }

    public City(int id, int countryId, String name, List<Hotel> hotels) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.hotels = hotels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
