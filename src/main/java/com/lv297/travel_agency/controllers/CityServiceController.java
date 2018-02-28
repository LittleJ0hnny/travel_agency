package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.service.CityService;
import com.lv297.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 27.02.18.
 */

@Controller
public class CityServiceController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping("/cities")
    public ModelAndView cityMain(){
        return new ModelAndView("cityMain", "cities", cityService.getAllCities());
    }

    @RequestMapping("/cities/selectCitiesByCountry/{id}")
    public ModelAndView citiesByCountry(@PathVariable int id){
        return new ModelAndView("cityMain", "cities", cityService.getAllCitiesForCountry(id));
    }
    @RequestMapping("/cities/searchCitiesByName")
    public ModelAndView searchCitiesByName(@RequestParam String name){
        return new ModelAndView("cityMain", "cities", cityService.searchCitiesByName(name));
    }

    @RequestMapping("/cities/getAllCities")
    public ModelAndView getAllCities(){
        return new ModelAndView("cityMain", "cities", cityService.getAllCities());
    }

    /*@RequestMapping(value = "/cities/createCity", method = RequestMethod.POST)
    public ModelAndView createCity(@RequestParam String name, @RequestParam int idOfCountry){
        City city = new City(name, countryService.getCountryById(idOfCountry));
        cityService.saveCity(city);
        return new ModelAndView("cityMain", "cities", cityService.getAllCities());
    }

    @RequestMapping(value = "/cities/deleteCity/{id}")
    public ModelAndView deleteCity(@PathVariable int id){
        cityService.deleteCityById(id);
        return new ModelAndView("cityMain", "cities", cityService.getAllCities());
    }

    @RequestMapping(value = "/cities/updateCity/{id}")
    public ModelAndView updateCity(@PathVariable int id){
        ModelAndView model = new ModelAndView("cityUpdate");
        model.addObject("objectToUpdate", cityService.getCityById(id));
        model.addObject("cities", cityService.getAllCities());
        return model;
    }

    @RequestMapping(value = "/cities/saveUpdatedCity/{id}")
    public ModelAndView saveUpdatedCity(@PathVariable int id, @RequestParam String name, @RequestParam int idOfCountry){
        City city = cityService.getCityById(id);
        city.setName(name);
        city.setCountry(countryService.getCountryById(idOfCountry));
        cityService.updateCity(city);
        return new ModelAndView("cityMain", "cities", cityService.getAllCities());
    }

    @RequestMapping(value = "/cities/cityGetById")
    public ModelAndView cityGetById(){
        return new ModelAndView("cityGetById");
    }

    @RequestMapping(value = "/countries/getCityById", method = RequestMethod.POST)
    public ModelAndView getCityById(@RequestParam int id){
        List<City> list = new ArrayList<>();
        list.add(cityService.getCityById(id));
        return new ModelAndView("cityMain", "cities", list);
    }*/


}
