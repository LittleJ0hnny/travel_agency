package com.lv297.travel_agency.database.entities;

import java.util.List;

public class Hotel {
    private int id;
    private int cityId;
    private String name;
    private List<Room> rooms;

    public Hotel(){}

    public Hotel(int id, int cityId, String name, List<Room> rooms) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
