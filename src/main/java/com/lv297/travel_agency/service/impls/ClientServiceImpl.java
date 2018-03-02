package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import com.lv297.travel_agency.repository.ClientRepository;
import com.lv297.travel_agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    @Transactional
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public boolean validatePassword(String password, String password2) {
        return !password.equals(password2);
    }

    @Override
    public boolean validateEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        if(client == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkEmailOnExist(String email) {
        Client client = clientRepository.findByEmail(email);
        if(client == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkClientVisas(Client client, Country country, LocalDate dateTo) {
        boolean result = false;
        for(Visa visa: client.getVisas()) {
            System.out.println(visa.getCountry().equals(country));
            if(visa.getCountry().equals(country) && dateTo.isBefore(visa.getValidTo())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
