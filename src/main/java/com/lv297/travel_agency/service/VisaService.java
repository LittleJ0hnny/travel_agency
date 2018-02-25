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
    List<Visa> visasForClient(Client client);
    List<Visa> activeVisasForClient(Client client);
    List<Country> visitedCountries(Client client);
}
