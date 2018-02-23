package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.HotelDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;


@Repository
public class HotelHibernateDAOImpl extends ElementDAO<Hotel, Integer> implements HotelDAO {

    HotelHibernateDAOImpl() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> findHotelsByCityName(String cityName) {
        City city;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT city FROM City city WHERE city.name=:name");
        query.setParameter("name", cityName);
        city = (City) query.getSingleResult();
        if (city == null) {
            return null;
        } else {
            return city.getHotels();
        }
    }

    @Override
    public List<Hotel> findFreeHotelInDate(String cityName, LocalDate date) {
        List hotels;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT DISTINCT room.hotel FROM Room room " +
                "WHERE room.hotel.city.name=:cityName AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE booking.bookingTo>DATE(:date) AND " +
                "booking.bookingFrom<=DATE(:date) AND " +
                "booking.hotel.city.name=:cityName)");
        query.setParameter("cityName", cityName);
        query.setParameter("date", date.toString());
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(String cityName, LocalDate dateFrom, LocalDate dateTo) {

        List hotels;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT DISTINCT room.hotel FROM Room room " +
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
        query.setParameter("dateFrom", dateFrom.toString());
        query.setParameter("dateTo", dateTo.toString());
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Client> clients(String hotelName) {
        List clients;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT DISTINCT booking.client FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        clients = query.getResultList();
        return clients;
    }

    @Override
    public int numberClients(String hotelName) {
        int number;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT COUNT(DISTINCT booking.client) FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        number = (int)(long)query.getSingleResult();
        return number;
    }



    @Override
    public List<Object> averageBookingTime(String hotelName) {
        List bookingsTime;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT booking.bookingTo, booking.bookingFrom " +
                "FROM Booking booking " +
                "WHERE booking.hotel.name=:hotelName");
        query.setParameter("hotelName",hotelName);
        bookingsTime = query.getResultList();
        return bookingsTime;
    }

    @Override
    public List<Object> statistic() {
        List statistic;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT booking.hotel, COUNT(DISTINCT booking.client), " +
                "AVG(booking.bookingTo-booking.bookingFrom) FROM Booking booking " +
                "GROUP BY booking.hotel");
//        Query query = entityManager.createQuery("SELECT booking.hotel,  booking.client, " +
//                "booking.bookingTo-booking.bookingFrom FROM Booking booking " +
//                "");
        statistic = query.getResultList();
        return null;
    }
}
