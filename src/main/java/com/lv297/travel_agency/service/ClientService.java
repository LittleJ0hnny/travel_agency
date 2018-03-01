package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Client;

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
}
