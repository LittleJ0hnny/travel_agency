package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaRepository extends JpaRepository<Visa, Integer> {
    int numberVisas(Client client);
    int numberActiveVisas(Client client);
    List<Visa> getAllVisasForCountry(int countryId);
    List<Visa> visasForClient(int clientId);
    List<Visa> activeVisasForClient(int clientId);
    List<Country> visitedCountries(int clientId);

}
