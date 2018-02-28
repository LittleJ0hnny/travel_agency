package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT country FROM Country country WHERE country.name LIKE %:name%")
    List<Country> searchCountryByName(@Param("name") String name);
}
