package com.lv297.travel_agency.service;


import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface CityService {
    City updateCity(City city);
    void deleteCity(City city);
    void saveCity(City city);
    City getCityById(int id);
    void deleteCityById(int id);
    List<City> getAllCities();
    List<City> getAllCitiesForCountry(int countryId);

}
