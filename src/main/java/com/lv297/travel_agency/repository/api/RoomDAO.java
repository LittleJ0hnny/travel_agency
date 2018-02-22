package com.lv297.travel_agency.repository.api;

import com.lv297.travel_agency.entities.Room;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.List;

public interface RoomDAO extends GenericDAO<Room, Integer> {
    List<Room> findFreeRoomInHotelInDate(String hotelName, String date);
    List<Room> findFreeRoomInHotelInDateRange(String hotelName, String dateFrom, String dateTo);
    List<Object> usingRoomsForHotelInDateRange(String hotelName, String dateFrom, String dateTo);
}
