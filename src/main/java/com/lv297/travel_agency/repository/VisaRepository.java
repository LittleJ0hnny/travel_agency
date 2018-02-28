package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VisaRepository extends JpaRepository<Visa, Integer> {


    @Query
    int findCountByClient_Id(int clientId);

    @Query("SELECT COUNT(visa) FROM Visa visa " +
            "WHERE visa.client.id=:id AND visa.validTo > DATE (:curentDate)")
    int numberActiveVisas(@Param("id") int clientId, @Param("curentDate") LocalDate curentDate);

    @Query
    List<Visa> findByCountry_Id(int countryId);

    @Query
    List<Visa> findByClient_Id(int clientId);

    @Query(value = "SELECT visa FROM Visa visa " +
            "WHERE visa.client.id=:id AND visa.validTo > DATE (:curentDate)")
    List<Visa> activeVisasForClient(@Param("id") int clientId, @Param("curentDate") LocalDate curentDate);

    @Query("SELECT DISTINCT visa.country FROM Visa visa " +
            "WHERE visa.client.id=:id AND visa.lastTimeUsed != DATE(0000-00-00)")
    List<Country> visitedCountries(@Param("id") int clientId);

}
