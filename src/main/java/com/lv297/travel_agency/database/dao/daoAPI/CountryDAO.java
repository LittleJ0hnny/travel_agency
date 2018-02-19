package com.lv297.travel_agency.database.dao.daoAPI;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;

import java.util.List;


public interface CountryDAO extends GenericDAO<Country, Integer> {
    int numberVisas(String name);
    List<Visa> visasForCountry(String name);

}
