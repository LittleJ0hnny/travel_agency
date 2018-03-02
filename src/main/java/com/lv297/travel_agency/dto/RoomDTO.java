package com.lv297.travel_agency.dto;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;

/**
 * Created by ivan on 01.03.18.
 */
public class RoomDTO {
    private Hotel hotel;
    private int sum;
    private int number;
    public RoomDTO(Room room, int number, int sum) {
        this.hotel = room.getHotel();
        this.sum = sum;
        this.number = number;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "hotel=" + hotel +
                ", sum=" + sum +
                ", number=" + number +
                '}';
    }
}
