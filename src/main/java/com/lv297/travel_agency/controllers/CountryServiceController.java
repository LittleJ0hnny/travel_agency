package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ivan on 27.02.18.
 */

@Controller
public class CountryServiceController {

    @Autowired
    private CountryService countryService;

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
}
