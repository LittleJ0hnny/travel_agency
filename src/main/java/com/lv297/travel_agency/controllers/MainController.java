package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.CityService;
import com.lv297.travel_agency.service.CountryService;
import com.lv297.travel_agency.service.HotelService;
import com.lv297.travel_agency.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ivan on 22.02.18.
 */

@Controller
public class MainController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private VisaService visaService;
    @Autowired
    private HotelService hotelService;


    @RequestMapping("/")
    public ModelAndView onIndex(){
        return getCountries();
    }

    @RequestMapping("/countries")
    public ModelAndView getCountries(){
        List countries = countryService.getAllCountries();
        ModelAndView model = new ModelAndView("ShowCountries");
        model.addObject("countries", countries);
        model.addObject("tableName","Countries");
        return model;
    }

    @RequestMapping("/cities/{id}")
    public ModelAndView getCities(@PathVariable int id){
        ModelAndView model = new ModelAndView("ShowCities");
        List cities;
        if (id != 0) {
            cities = cityService.getAllCitiesForCountry(id);
        } else{
            cities = cityService.getAllCities();
        }
        model.addObject("cities", cities);
        model.addObject("tableName","Cities");
        return model;
    }

    @RequestMapping("/visas/{id}")
    public ModelAndView getVisas(@PathVariable int id){
        List visas = visaService.getAllVisasForCountry(id);
        ModelAndView model = new ModelAndView("ShowVisas");
        model.addObject("visas", visas);
        model.addObject("tableName","Visas");
        return model;
    }

    @RequestMapping("/hotels/{id}")
    public ModelAndView getHotels(@PathVariable int id){
        List hotels;
        ModelAndView model = new ModelAndView("ShowHotels");
        if (id!=0){
            hotels = hotelService.getAllHotelsForCity(id);
        }else {
            hotels = hotelService.getAllHotels();
        }
        model.addObject("hotels", hotels);
        model.addObject("tableName","Hotels");
        return model;
    }

    @RequestMapping("/delete/{element}/{id}")
    public ModelAndView deleteElement(@PathVariable String element, int id){
//        if (element.equals("country")){
//            countryService.deleteCountryById(id);
//            return getCountries();
//        } else if(element.equals("city")){
//            cityService.deleteCityById(id);
//
//        }
        return null;
    }
}
