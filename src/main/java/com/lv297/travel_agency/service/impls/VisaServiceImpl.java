package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import com.lv297.travel_agency.repository.VisaRepository;
import com.lv297.travel_agency.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaServiceImpl implements VisaService {
    @Autowired
    private VisaRepository visaRepository;

    @Override
    public Visa updateVisa(Visa visa) {
        return null;
    }

    @Override
    public void deleteVisa(Visa visa) {
        visaRepository.delete(visa);
    }

    @Override
    public void saveVisa(Visa visa) {
        visaRepository.save(visa);
    }

    @Override
    public Visa getVisaById(int id) {
        return visaRepository.getOne(id);
    }

    @Override
    public List<Visa> getAllVisas() {
        return visaRepository.findAll();
    }

    @Override
    public int numberVisas(Client client) {
        return visaRepository.numberVisas(client);
    }

    @Override
    public int numberActiveVisas(Client client) {
        return visaRepository.numberActiveVisas(client);
    }

    @Override
    public List<Visa> visasForClient(Client client) {
        return visaRepository.visasForClient(client);
    }

    @Override
    public List<Visa> activeVisasForClient(Client client) {
        return visaRepository.activeVisasForClient(client);
    }

    @Override
    public List<Country> visitedCountries(Client client) {
        return visaRepository.visitedCountries(client);
    }


}
