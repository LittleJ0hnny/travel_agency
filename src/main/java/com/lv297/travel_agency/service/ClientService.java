package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;

import java.time.LocalDate;
import java.util.List;

public interface ClientService {
    Client updateClient(Client client);
    void deleteClient(Client client);
    void saveClient(Client client);
    Client getClientById(int id);
    Client getClientByEmail(String email);
    List<Client> getAllClients();
    boolean validatePassword(String password, String password2);
    boolean validateEmail(String email);
    boolean checkEmailOnExist(String email);
    boolean checkClientVisas(Client client, Country country, LocalDate dateTo);
}
