package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.BookingDAO;
import com.lv297.travel_agency.entities.Booking;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookingHibernateDAOImpl extends ElementDAO<Booking, Integer> implements BookingDAO {

    public BookingHibernateDAOImpl() {
        super(Booking.class);
    }
}
