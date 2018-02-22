package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(int id);
    void deleteCountryById(int id);
}
