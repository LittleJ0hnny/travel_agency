package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> getAllHotelsForCity(int id);
    List<Hotel> findFreeHotelInDate(int cityId, LocalDate date);
    List<Hotel> findFreeHotelInDateRange(int cityId, LocalDate dateFrom, LocalDate dateTo);
    List<Room> findFreeRoomInHotelInDate(Hotel hotel, LocalDate date);
    List<Room> findFreeRoomInHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
    List<Object> usingRoomsForHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
}
