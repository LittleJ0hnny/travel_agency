package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ivan on 27.02.18.
 */

@Controller
public class CityServiceController {

    @Autowired
    private CityService cityService;

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
}
