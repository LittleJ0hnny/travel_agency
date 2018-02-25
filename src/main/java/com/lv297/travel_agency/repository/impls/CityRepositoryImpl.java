package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.repository.CityRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CityRepositoryImpl extends SimpleJpaRepository<City, Integer> implements CityRepository {
    private final EntityManager entityManager;

    public CityRepositoryImpl(EntityManager entityManager) {
        super(City.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Hotel> findFreeHotelInDate(City city, LocalDate date) {
        List hotels;
        Query query = entityManager.createQuery("SELECT DISTINCT room.hotel FROM Room room " +
                "WHERE room.hotel.city.id=:id AND " +
                "room.id NOT IN (SELECT booking.room.id FROM Booking booking " +
                "WHERE booking.bookingTo>DATE(:date) AND " +
                "booking.bookingFrom<=DATE(:date) AND " +
                "booking.hotel.city.id=:id)");
        query.setParameter("id", city.getId());
        query.setParameter("date", date.toString());
        hotels = query.getResultList();
        return hotels;
    }

    @Override
    public List<Hotel> findFreeHotelInDateRange(City city, LocalDate dateFrom, LocalDate dateTo) {
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
        query.setParameter("id", city.getId());
        query.setParameter("dateFrom", dateFrom.toString());
        query.setParameter("dateTo", dateTo.toString());
        hotels = query.getResultList();
        return hotels;
    }
}
