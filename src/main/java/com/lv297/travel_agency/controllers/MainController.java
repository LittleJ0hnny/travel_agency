package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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
    @Autowired
    private RoomService roomService;
    @Autowired
    private ClientService clientService;


    @RequestMapping("/")
    public ModelAndView onIndex(){
        return new ModelAndView("countryMain");
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
