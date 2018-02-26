package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> getAllCitiesForCountry(int countryId);
}
