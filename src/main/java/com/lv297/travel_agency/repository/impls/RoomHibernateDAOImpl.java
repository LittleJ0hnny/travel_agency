package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.RoomDAO;
import com.lv297.travel_agency.entities.Room;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class RoomHibernateDAOImpl extends ElementDAO<Room, Integer> implements RoomDAO {

    public RoomHibernateDAOImpl() {
        super(Room.class);
    }


    @Override
    public List<Room> findFreeRoomInHotelInDate(String hotelName, String date) {
        List rooms;
        Query query = super.entityManager.createQuery("SELECT room FROM Room room " +
                "WHERE room.hotel.name=:hotelName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                                    "WHERE booking.bookingTo>DATE(:date) AND " +
                                            "booking.bookingFrom<=DATE(:date) AND " +
                                            "booking.hotel.name=:hotelName)");
        query.setParameter("hotelName", hotelName);
        query.setParameter("date", date);
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> findFreeRoomInHotelInDateRange(String hotelName, String dateFrom, String dateTo) {
        List rooms;
        Query query = super.entityManager.createQuery("SELECT room FROM Room room " +
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
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateTo);
        rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Object> usingRoomsForHotelInDateRange(String hotelName, String dateFrom, String dateTo) {
        List usingRooms;
//        EntityManager entityManager = HibernateUtil.getEntityManager();
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
