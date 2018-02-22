package com.lv297.travel_agency.repository.api;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Hotel;

import java.util.List;

public interface HotelDAO extends GenericDAO<Hotel, Integer> {
    List<Hotel> findHotelsByCityName(String cityName);
    List<Hotel> findFreeHotelInDate(String cityName, String date);
    List<Hotel> findFreeHotelInDateRange(String cityName, String dateFrom, String dateTo);
    List<Client> clients(String hotelName);
    int numberClients(String hotelName);
    double averageBookingTime(String hotelName);
    List<Object> statistic();
}
