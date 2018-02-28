package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.repository.CountryRepository;
import com.lv297.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Country getCountryById(int id) {
        return countryRepository.getOne(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteCountryById(int id) {
        Country country = getCountryById(id);
        if (country != null) {
            deleteCountry(country);
        }
    }
}
