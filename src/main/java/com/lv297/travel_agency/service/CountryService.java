package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Country;

import java.util.List;

public interface CountryService {
    Country updateCountry(Country country);
    void deleteCountry(Country country);
    void saveCountry(Country country);
    Country getCountryById(int id);
    List<Country> getAllCountries();
}
