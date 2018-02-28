package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country merge(Country country);

}
