package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaRepository extends JpaRepository<Visa, Integer> {
    int numberVisas(Client client);
    int numberActiveVisas(Client client);
    List<Visa> visasForClient(Client client);
    List<Visa> activeVisasForClient(Client client);
    List<Country> visitedCountries(Client client);

}
