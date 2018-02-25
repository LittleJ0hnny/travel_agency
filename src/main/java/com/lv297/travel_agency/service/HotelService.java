package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    void saveHotel(Hotel hotel);
    Hotel getHotelById(int id);
    List<Hotel> getAllHotels();
    List<Hotel> getAllHotelsForCity(int id);
    List<Room> findFreeRoomInHotelInDate(Hotel hotel, LocalDate date);
    List<Room> findFreeRoomInHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
}
