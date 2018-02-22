package com.lv297.travel_agency.repository.api;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;

import java.util.List;

public interface ClientDAO extends GenericDAO<Client, Integer> {
    int numberVisas(String firstname, String lastname);
    int numberActiveVisas(String firstname, String lastname);
    List<Visa> visasForClient(String firstname, String lastname);
    List<Visa> activeVisasForClient(String firstname, String lastname);
    List<Country> visitedCountries(String firstname, String lastname);
}
