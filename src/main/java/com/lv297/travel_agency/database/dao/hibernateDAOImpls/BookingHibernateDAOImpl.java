package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.BookingDAO;
import com.lv297.travel_agency.entities.Booking;

public class BookingHibernateDAOImpl extends ElementDAO<Booking, Integer> implements BookingDAO {

    BookingHibernateDAOImpl() {
        super(Booking.class);
    }
}
