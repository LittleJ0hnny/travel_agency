package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.repository.CityRepository;
import com.lv297.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City updateCity(City city) {
        return null;
    }

    @Override
    public void deleteCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getCityById(int id) {
        return cityRepository.getOne(id);
    }

    @Override
    public void deleteCityById(int id) {
        City city = getCityById(id);
        if (city!=null) {
            deleteCity(city);
        }
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    @Override
    public List<City> getAllCitiesForCountry(int countryId) {
        return cityRepository.getAllCitiesForCountry(countryId);
    }
}
