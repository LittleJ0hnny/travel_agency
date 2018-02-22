package com.lv297.travel_agency.repository.api;

import com.lv297.travel_agency.entities.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {
    List<Hotel> findHotelsByCityName(String cityName);
}
