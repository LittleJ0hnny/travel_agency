package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
