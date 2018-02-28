package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.VisaService;
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
public class VisaServiceController {

    @Autowired
    private VisaService visaService;

    @RequestMapping("/visas/{id}")
    public ModelAndView getVisas(@PathVariable int id) {
        List visas = visaService.getAllVisasForCountry(id);
        ModelAndView model = new ModelAndView("ShowVisas");
        model.addObject("visas", visas);
        model.addObject("tableName", "Visas");
        return model;
    }

    @RequestMapping("/visitedCountry/{id}")
    public ModelAndView getVisitedCountriesForClient(@PathVariable int id) {
        ModelAndView model = new ModelAndView("visitedCountries");
        List countries;
        countries = visaService.visitedCountries(id);
        model.addObject("countries", countries);
        return model;
    }

    @RequestMapping("/clientVisas/{state}/{id}")
    public ModelAndView getVisasForClient(@PathVariable String state, @PathVariable int id) {
        List visas;
        ModelAndView model = new ModelAndView("clientsVisas");
        if (state.equals("active")) {
            visas = visaService.activeVisasForClient(id);
        } else {
            visas = visaService.visasForClient(id);
        }
        model.addObject("visas", visas);
        return model;
    }
}
