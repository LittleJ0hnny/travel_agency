package com.lv297.travel_agency.service.impls;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.repository.CityRepository;
import com.lv297.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public void deleteCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    @Transactional
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getCityById(int id) {
        return cityRepository.getOne(id);
    }

    @Override
    @Transactional
    public void deleteCityById(int id) {
        City city = getCityById(id);
        if (city != null) {
            deleteCity(city);
        }
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    @Override
    public List<City> getAllCitiesForCountry(int countryId) {
        return cityRepository.findByCountry_Id(countryId);
    }

    @Override
    public List<City> searchCitiesByName(String name) {
        return cityRepository.searchCitiesByName(name);
    }

    @Override
    public List<City> searchCitiesByNameForCountry(String name, int countryId) {
        return cityRepository.searchCitiesByNameForCountry(name,countryId);
    }
}
