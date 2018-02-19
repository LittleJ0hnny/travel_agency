package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.HotelDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HotelHibernateDAOImpl extends ElementDAO<Hotel, Integer> implements HotelDAO {

    HotelHibernateDAOImpl() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> findHotelsByCityName(String cityName) {
        City city;
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT city FROM City city WHERE city.name=:name");
        query.setParameter("name", cityName);
        city = (City) query.getSingleResult();
        if (city == null) {
            return null;
        } else {
            return city.getHotels();
        }
    }

    @Override
    public List<Hotel> findFreeHotelInDate(String cityName, String date) {
        List hotels;
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
                "WHERE room.hotel.city.name=:cityName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE booking.bookingTo>DATE(:date) AND " +
                "booking.bookingFrom<=DATE(:date) AND " +
                "booking.hotel.city.name=:cityName)");
        query.setParameter("cityName", cityName);
        query.setParameter("date", date);
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(String cityName, String dateFrom, String dateTo) {

        List hotels;
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
                "WHERE room.hotel.city.name=:cityName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE ((booking.bookingTo>DATE(:dateFrom) AND " +
                "booking.bookingFrom<=DATE(:dateFrom)) OR " +
                "(booking.bookingTo>=DATE(:dateTo) AND " +
                "booking.bookingFrom<DATE(:dateTo)) OR " +
                "(DATE(:dateFrom)<=booking.bookingFrom AND " +
                "DATE(:dateFrom)<booking.bookingTo AND " +
                "DATE(:dateTo)>booking.bookingFrom AND " +
                "DATE(:dateTo)>=booking.bookingTo)) AND " +
                "booking.hotel.city.name=:cityName)");
        query.setParameter("cityName", cityName);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo", dateTo);
        hotels = query.getResultList();
        return hotels;
    }
}
