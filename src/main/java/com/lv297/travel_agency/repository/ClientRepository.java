package com.lv297.travel_agency.repository;

import com.lv297.travel_agency.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query
    Client findByEmail(String email);
}
