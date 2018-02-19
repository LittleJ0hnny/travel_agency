package com.lv297.travel_agency.database.dao.daoAPI;

import com.lv297.travel_agency.entities.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {
    List<Hotel> findHotelsByCityName(String cityName);
    List<Hotel> findFreeHotelInDate(String cityName, String date);
    List<Hotel> findFreeHotelInDateRange(String cityName, String dateFrom, String dateTo);
}
