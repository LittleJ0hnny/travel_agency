package com.lv297.travel_agency.service;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.repository.api.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ServiceCountry {

    private CountryDAO countryDAO;

    public List<Country> getCountries(){
        return countryDAO.findAll();
    }

    public CountryDAO getCountryDAO() {
        return countryDAO;
    }

    @Autowired
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
}
