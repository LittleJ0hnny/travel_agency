package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.repository.HotelRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class HotelRepositoryImpl extends SimpleJpaRepository<Hotel, Integer> implements HotelRepository {
    private final EntityManager entityManager;

    public HotelRepositoryImpl(EntityManager entityManager) {
        super(Hotel.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Hotel> getAllHotelsForCity(int id) {
        List hotels;
        Query query = entityManager.createQuery("SELECT hotel FROM Hotel hotel " +
                "WHERE hotel.city.id=:id");
        query.setParameter("id", id);
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Hotel> findFreeHotelInDate(int cityId, LocalDate date) {
        List hotels;
        Query query = entityManager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
                "WHERE room.hotel.city.id=:id AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE booking.bookingTo>DATE(:date) AND " +
                "booking.bookingFrom<=DATE(:date) AND " +
                "booking.hotel.city.id=:id)");
        query.setParameter("id", cityId);
        query.setParameter("date", date.toString());
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(int cityId, LocalDate dateFrom, LocalDate dateTo) {
        List hotels;
        Query query = entityManager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
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
                "booking.hotel.city.id=:id)");
        query.setParameter("id", cityId);
        query.setParameter("dateFrom", dateFrom.toString());
        query.setParameter("dateTo", dateTo.toString());
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public int numberClients(int hotelId) {
        int number;
        Query query = entityManager.createQuery("SELECT COUNT(DISTINCT booking.client) FROM Booking booking " +
                "WHERE booking.hotel.id=:hotelId");
        query.setParameter("hotelId",hotelId);
        number = (int)(long)query.getSingleResult();
        return number;
    }



    @Override
    public List<Object> averageBookingTime(int hotelId) {
        List bookingsTime;
        Query query = entityManager.createQuery("SELECT booking.bookingTo, booking.bookingFrom " +
                "FROM Booking booking " +
                "WHERE booking.hotel.id=:hotelId");
        query.setParameter("hotelId",hotelId);
        bookingsTime = query.getResultList();
        return bookingsTime;
    }

    @Override
    public List<Object> usingRoomsForHotelInDateRange(Hotel hotel, LocalDate dateFrom, LocalDate dateTo) {
        List usingRooms;

//        Query query = entityManager.createQuery("SELECT k.booking.room, k.dat FROM" +
//                "(" +
//                "SELECT booking.room, (booking.bookingTo-booking.bookingFrom) AS dat " +
//                "FROM Booking booking " +
//                ") AS k " +
//                "GROUP BY k.booking.room");
//        query.setParameter("dateFrom", dateFrom);
//        query.setParameter("dateTo", dateTo);
//        usingRooms = query.getResultList();
        return null;
    }
}
