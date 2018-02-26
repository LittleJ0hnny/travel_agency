package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;

import java.util.List;

public interface VisaService {
    Visa updateVisa(Visa visa);
    void deleteVisa(Visa visa);
    void saveVisa(Visa visa);
    Visa getVisaById(int id);
    List<Visa> getAllVisas();
    int numberVisas(Client client);
    int numberActiveVisas(Client client);
    void deleteVisaById(int id);
    List<Visa> getAllVisasForCountry(int countryId);
    List<Visa> visasForClient(int clientId);
    List<Visa> activeVisasForClient(int clientId);
    List<Country> visitedCountries(int clientId);
}
