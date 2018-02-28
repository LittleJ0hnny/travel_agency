package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query
    List<City> findByCountry_Id(int Id);
    List<City> getAllCitiesForCountry(int countryId);
    City merge(City city);
}
