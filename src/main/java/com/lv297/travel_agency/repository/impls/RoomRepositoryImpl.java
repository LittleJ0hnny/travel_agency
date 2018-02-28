package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.repository.RoomRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class RoomRepositoryImpl extends SimpleJpaRepository<Room, Integer> implements RoomRepository {
    private final EntityManager entityManager;

    public RoomRepositoryImpl(EntityManager entityManager) {
        super(Room.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Room> getAllRoomsForHotel(int id) {
        List rooms;
        Query query = entityManager.createQuery("SELECT room FROM Room room " +
                "WHERE room.hotel.id=:id");
        query.setParameter("id", id);
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> findFreeRoomInHotelInDate(int hotelId, LocalDate date) {
        List rooms;
        Query query = entityManager.createQuery("SELECT room FROM Room room " +
                "WHERE room.hotel.id=:id AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE booking.bookingTo>DATE(:date) AND " +
                "booking.bookingFrom<=DATE(:date) AND " +
                "booking.hotel.id=:id)");
        query.setParameter("id", hotelId);
        query.setParameter("date", date.toString());
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> findFreeRoomInHotelInDateRange(int hotelId, LocalDate dateFrom, LocalDate dateTo) {
        List rooms;
        Query query = entityManager.createQuery("SELECT room FROM Room room " +
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
                "booking.hotel.id=:id)");
        query.setParameter("id", hotelId);
        query.setParameter("dateFrom", dateFrom.toString());
        query.setParameter("dateTo", dateTo.toString());
        rooms = query.getResultList();
        return rooms;
    }
}
