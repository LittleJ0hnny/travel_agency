package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.HotelDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HotelHibernateDAOImpl implements HotelDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Hotel update(Hotel entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void save(Hotel entity) {

    }

    @Override
    public void delete(Hotel entity) {

    }

    @Override
    public Hotel find(Integer id) {
        return null;
    }

    @Override
    public List<Hotel> findAll() {
        return null;
    }

    @Override
    public List<Hotel> findHotelsByCityName(String cityName) {
        City city;
        Query query = entityManager.createQuery("SELECT city FROM City city WHERE city.name=:name");
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
        Query query = entityManager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
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
        Query query = entityManager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
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

    @Override
    public List<Client> clients(String hotelName) {
        List clients;
        Query query = entityManager.createQuery("SELECT DISTINCT booking.client FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        clients = query.getResultList();
        return clients;
    }

    @Override
    public int numberClients(String hotelName) {
        int number;
        Query query = entityManager.createQuery("SELECT COUNT(DISTINCT booking.client) FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        number = (int)(long)query.getSingleResult();
        return number;
    }

    @Override
    public double averageBookingTime(String hotelName) {
        double averageTime;
        Query query = entityManager.createQuery("SELECT AVG(booking.bookingTo-booking.bookingFrom) " +
                "FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        averageTime = (double) query.getSingleResult();
        return averageTime;
    }

    @Override
    public List<Object> statistic() {
        List statistic;
        Query query = entityManager.createQuery("SELECT booking.hotel, COUNT(DISTINCT booking.client), " +
                "AVG(booking.bookingTo-booking.bookingFrom) FROM Booking booking " +
                "GROUP BY booking.hotel");
//        Query query = entityManager.createQuery("SELECT booking.hotel,  booking.client, " +
//                "booking.bookingTo-booking.bookingFrom FROM Booking booking " +
//                "");
        statistic = query.getResultList();
        return statistic;
    }


}
