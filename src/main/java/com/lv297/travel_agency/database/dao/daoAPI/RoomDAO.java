package com.lv297.travel_agency.database.dao.daoAPI;

import com.lv297.travel_agency.entities.Room;

import java.util.List;

public interface RoomDAO extends GenericDAO<Room, Integer> {
    List<Room> findFreeRoomInHotelInDate(String hotelName, String date);
    List<Room> findFreeRoomInHotelInDateRange(String hotelName, String dateFrom, String dateTo);
}
