package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.repository.CountryRepository;
import com.lv297.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getCountryById(int id) {
        return countryRepository.getOne(id);
    }

    @Override
    public void deleteCountryById(int id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
