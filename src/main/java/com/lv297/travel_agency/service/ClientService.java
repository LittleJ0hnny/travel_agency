package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Client;

import java.util.List;

public interface ClientService {
    Client updateCountry(Client client);
    void deleteClient(Client client);
    void saveClient(Client client);
    Client getClientById(int id);
    List<Client> getAllClients();
}
