package com.lv297.travel_agency.service;

import com.lv297.travel_agency.dto.RoomDTO;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.dto.HotelDTO;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    void saveHotel(Hotel hotel);
    Hotel getHotelById(int id);
    List<Hotel> getAllHotels();
    List<Hotel> getAllHotelsForCity(int id);
    List<Hotel> findFreeHotelInDateRange(int cityId, LocalDate dateFrom, LocalDate dateTo);
    List<HotelDTO> hotelsStatistic();
    List<Hotel> searchHotelsByNameForCity(String name, int cityId);
}
