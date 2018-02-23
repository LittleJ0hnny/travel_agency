package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.BookingDAO;
import com.lv297.travel_agency.entities.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class BookingHibernateDAOImpl extends ElementDAO<Booking, Integer> implements BookingDAO {

    BookingHibernateDAOImpl() {
        super(Booking.class);
    }
}
