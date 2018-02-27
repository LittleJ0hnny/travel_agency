package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    Room updateRoom(Room room);
    void deleteRoom(Room room);
    void saveRoom(Room room);
    Room getRoomById(int id);
    List<Room> getAllRooms();
    List<Room> getAllRoomsForHotel(int id);
    List<Room> findFreeRoomInHotelInDateRange(int hotelId, LocalDate dateFrom, LocalDate dateTo);
}
