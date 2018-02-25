package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Room;

import java.util.List;

public interface RoomService {
    Room updateRoom(Room room);
    void deleteRoom(Room room);
    void saveRoom(Room room);
    Room getRoomById(int id);
    List<Room> getAllRooms();
}
