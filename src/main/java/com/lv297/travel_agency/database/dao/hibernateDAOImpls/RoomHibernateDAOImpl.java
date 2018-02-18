package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.RoomDAO;
import com.lv297.travel_agency.entities.Room;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RoomHibernateDAOImpl extends ElementDAO<Room, Integer> implements RoomDAO {

    RoomHibernateDAOImpl() {
        super(Room.class);
    }

    private String getIdHotelByName = "(SELECT hotel.id FROM Hotel hotel WHERE hotel.name=:hotelName)";

    @Override
    public List<Room> findFreeRoomInHotelInDate(String hotelName, String date) {
        List rooms;
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT room FROM Room room " +
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
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT room FROM Room room " +
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
}
