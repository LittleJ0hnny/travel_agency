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
    public ModelAndView getVisas(@PathVariable int id){
        List visas = visaService.getAllVisasForCountry(id);
        ModelAndView model = new ModelAndView("ShowVisas");
        model.addObject("visas", visas);
        model.addObject("tableName","Visas");
        return model;
    }

    @RequestMapping("/visitedCountry/{id}")
    public ModelAndView getVisitedCountriesForClient(@PathVariable int id){
        ModelAndView model = new ModelAndView("ShowVisitedCountries");
        List visas;
        visas = visaService.visitedCountries(id);
        model.addObject("visas", visas);
        model.addObject("tableName","Visited Countries");
        return model;
    }

    @RequestMapping("/clientVisas/{state}/{id}")
    public ModelAndView getVisasForClient(@PathVariable String state, @PathVariable int id){
        List visas;
        ModelAndView model = new ModelAndView("ShowVisas");
        if (state.equals("active")){
            visas = visaService.activeVisasForClient(id);
            model.addObject("tableName","Active client's Visas");
        }else{
            visas = visaService.visasForClient(id);
            model.addObject("tableName","All client's Visas");
        }
        model.addObject("visas", visas);
        return model;
    }
}
