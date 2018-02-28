package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.entities.Country;
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
public class CountryServiceController {

    @Autowired
    private CountryService countryService;


    @RequestMapping("/countries")
    public ModelAndView countryMain(){
        return new ModelAndView("countryMain","countries", countryService.getAllCountries());
    }
    @RequestMapping("/countries/searchCountriesByName")
    public ModelAndView searchCountriesByName(@RequestParam String name){
        return new ModelAndView("countryMain","countries", countryService.searchCountriesByName(name));
    }

    @RequestMapping("/countries/statistic")
    public ModelAndView getCountryStatistic(){
        return new ModelAndView("countryStatisticMain", "countries", countryService.getAllCountries());
    }
    /*@RequestMapping("/countries/getAllCountries")
    public ModelAndView getAllCountries(){
        return new ModelAndView("countryMain", "countries", countryService.getAllCountries());
    }*/
    /*@RequestMapping(value = "/countries/createCountry", method = RequestMethod.POST)
    public ModelAndView createCountry(@RequestParam String name){
        countryService.saveCountry(new Country(name));
        return new ModelAndView("countryMain", "countries", countryService.getAllCountries());
    }
    @RequestMapping(value = "/countries/deleteCountry/{id}")
    public ModelAndView deleteCountry(@PathVariable int id){
        countryService.deleteCountryById(id);
        return new ModelAndView("countryMain", "countries", countryService.getAllCountries());
    }
    @RequestMapping(value = "/countries/updateCountry/{id}")
    public ModelAndView updateCountry(@PathVariable int id){
        ModelAndView model = new ModelAndView("countryUpdate");
        model.addObject("objectToUpdate", countryService.getCountryById(id));
        model.addObject("countries", countryService.getAllCountries());
        return model;
    }
    @RequestMapping(value = "/countries/saveUpdatedCountry/{id}")
    public ModelAndView saveUpdatedCountry(@PathVariable int id, @RequestParam String name){
        Country country = countryService.getCountryById(id);
        country.setName(name);
        countryService.updateCountry(country);
        return new ModelAndView("countryMain", "countries", countryService.getAllCountries());
    }

    @RequestMapping(value = "/countries/countryGetById")
    public ModelAndView countryGetById(){
        return new ModelAndView("countryGetById");
    }

    @RequestMapping(value = "/countries/getCountryById", method = RequestMethod.POST)
    public ModelAndView getCountryById(@RequestParam int id){
        List<Country> list = new ArrayList<>();
        list.add(countryService.getCountryById(id));
        return new ModelAndView("countryMain", "countries", list);
    }*/
}
