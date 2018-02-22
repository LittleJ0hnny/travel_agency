package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl {
    @Autowired
    private BookingRepository bookingRepository;

}
