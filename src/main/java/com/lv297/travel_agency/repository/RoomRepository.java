package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> getAllRoomsForHotel(int id);
    List<Room> findFreeRoomInHotelInDate(int hotelId, LocalDate date);
    List<Room> findFreeRoomInHotelInDateRange(int hotelId, LocalDate dateFrom, LocalDate dateTo);
}
