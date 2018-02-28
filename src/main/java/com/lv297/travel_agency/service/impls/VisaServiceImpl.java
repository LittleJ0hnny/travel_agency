package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import com.lv297.travel_agency.repository.VisaRepository;
import com.lv297.travel_agency.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class VisaServiceImpl implements VisaService {
    @Autowired
    private VisaRepository visaRepository;

    @Override
    @Transactional
    public Visa updateVisa(Visa visa) {
        return null;
    }

    @Override
    @Transactional
    public void deleteVisa(Visa visa) {
        visaRepository.delete(visa);
    }

    @Override
    @Transactional
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
    public int numberVisas(int clientId) {
        return visaRepository.findCountByClient_Id(clientId);
    }

    @Override
    public int numberActiveVisas(int clientId) {
        return visaRepository.numberActiveVisas(clientId, LocalDate.now());
    }

    @Override
    @Transactional
    public void deleteVisaById(int id) {
        Visa visa = getVisaById(id);
        if (visa != null) {
            deleteVisa(visa);
        }
    }

    @Override
    public List<Visa> getAllVisasForCountry(int countryId) {
        return visaRepository.findByCountry_Id(countryId);
    }

    @Override
    public List<Visa> visasForClient(int clientId) {
        return visaRepository.findByClient_Id(clientId);
    }

    @Override
    public List<Visa> activeVisasForClient(int clientId) {
        return visaRepository.activeVisasForClient(clientId, LocalDate.now());
    }

    @Override
    public List<Country> visitedCountries(int clientId) {
        return visaRepository.visitedCountries(clientId);
    }


}
