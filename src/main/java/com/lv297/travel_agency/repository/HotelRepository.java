package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Room> findFreeRoomInHotelInDate(Hotel hotel, LocalDate date);
    List<Room> findFreeRoomInHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
    List<Object> usingRoomsForHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
}
