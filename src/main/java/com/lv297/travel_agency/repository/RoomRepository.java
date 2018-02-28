package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    //    List<Room> getAllRoomsForHotel(int id);
    @Query
    List<Room> findByHotel_Id(int id);

    @Query("SELECT room FROM Room room " +
            "WHERE room.hotel.id=:id AND " +
            "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
            "WHERE ((booking.bookingTo>DATE(:dateFrom) AND " +
            "booking.bookingFrom<=DATE(:dateFrom)) OR " +
            "(booking.bookingTo>=DATE(:dateTo) AND " +
            "booking.bookingFrom<DATE(:dateTo)) OR " +
            "(DATE(:dateFrom)<=booking.bookingFrom AND " +
            "DATE(:dateFrom)<booking.bookingTo AND " +
            "DATE(:dateTo)>booking.bookingFrom AND " +
            "DATE(:dateTo)>=booking.bookingTo)) AND " +
            "booking.hotel.id=:id)")
    List<Room> findFreeRoomInHotelInDateRange(@Param("id") int hotelId,@Param("dateFrom") LocalDate dateFrom,@Param("dateTo") LocalDate dateTo);
}
