package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query
    List<City> findByCountry_Id(int Id);

    @Query("SELECT city FROM City city WHERE city.name LIKE %:name%")
    List<City> searchCitiesByName(@Param("name") String name);

    @Query("SELECT city FROM City city WHERE city.name LIKE %:name% AND city.country.id=:countryId" )
    List<City> searchCitiesByNameForCountry(@Param("name") String name, @Param("countryId") int countryId);
}
