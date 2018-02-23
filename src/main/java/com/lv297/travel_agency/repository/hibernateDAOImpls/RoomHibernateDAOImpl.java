package com.lv297.travel_agency.repository.hibernateDAOImpls;


import com.lv297.travel_agency.database.dao.daoAPI.RoomDAO;
import com.lv297.travel_agency.entities.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomHibernateDAOImpl extends ElementDAO<Room, Integer> implements RoomDAO {

    RoomHibernateDAOImpl() {
        super(Room.class);
    }


    @Override
    public List<Room> findFreeRoomInHotelInDate(String hotelName, LocalDate date) {
        List rooms;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT room FROM Room room " +
                "WHERE room.hotel.name=:hotelName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                                    "WHERE booking.bookingTo>DATE(:date) AND " +
                                            "booking.bookingFrom<=DATE(:date) AND " +
                                            "booking.hotel.name=:hotelName)");
        query.setParameter("hotelName", hotelName);
        query.setParameter("date", date.toString());
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> findFreeRoomInHotelInDateRange(String hotelName, LocalDate dateFrom, LocalDate dateTo) {

        List rooms;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT room FROM Room room " +
                "WHERE room.hotel.name=:hotelName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE ((booking.bookingTo>DATE(:dateFrom) AND " +
                "booking.bookingFrom<=DATE(:dateFrom)) OR " +
                "(booking.bookingTo>=DATE(:dateTo) AND " +
                "booking.bookingFrom<DATE(:dateTo)) OR " +
                "(DATE(:dateFrom)<=booking.bookingFrom AND " +
                "DATE(:dateFrom)<booking.bookingTo AND " +
                "DATE(:dateTo)>booking.bookingFrom AND " +
                "DATE(:dateTo)>=booking.bookingTo)) AND " +
                "booking.hotel.name=:hotelName)");
        query.setParameter("hotelName", hotelName);
        query.setParameter("dateFrom", dateFrom.toString());
        query.setParameter("dateTo", dateTo.toString());
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Object> usingRoomsForHotelInDateRange(String hotelName, LocalDate dateFrom, LocalDate dateTo) {
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
