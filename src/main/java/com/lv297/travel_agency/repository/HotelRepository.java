package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query
    List<Hotel> findByCity_Id(int id);

    @Query("SELECT DISTINCT room.hotel FROM Room room " +
            "WHERE room.hotel.city.id=:id AND " +
            "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
            "WHERE ((booking.bookingTo>DATE(:dateFrom) AND " +
            "booking.bookingFrom<=DATE(:dateFrom)) OR " +
            "(booking.bookingTo>=DATE(:dateTo) AND " +
            "booking.bookingFrom<DATE(:dateTo)) OR " +
            "(DATE(:dateFrom)<=booking.bookingFrom AND " +
            "DATE(:dateFrom)<booking.bookingTo AND " +
            "DATE(:dateTo)>booking.bookingFrom AND " +
            "DATE(:dateTo)>=booking.bookingTo)) AND " +
            "booking.hotel.city.id=:id)")
    List<Hotel> findFreeHotelInDateRange(@Param("id") int cityId,
                                         @Param("dateFrom") LocalDate dateFrom,
                                         @Param("dateTo") LocalDate dateTo);

    /*List<Object> usingRoomsForHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);*/

    @Query("SELECT COUNT(DISTINCT booking.client) FROM Booking booking " +
            "WHERE booking.hotel.id=:hotelId")
    int numberClients(@Param("hotelId") int hotelId);

    @Query("SELECT AVG(TO_DAYS(booking.bookingTo)-TO_DAYS(booking.bookingFrom)) " +
            "FROM Booking booking WHERE booking.hotel.id=:hotelId")
    double averageBookingTime(@Param("hotelId") int hotelId);
}
