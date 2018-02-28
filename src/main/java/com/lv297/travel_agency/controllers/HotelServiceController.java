package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.HotelService;
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
 * Created by ivan on 27.02.18.
 */

@Controller
public class HotelServiceController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotels")
    public ModelAndView getHotels(){
        return new ModelAndView("hotelMain", "hotels", hotelService.getAllHotels());
    }

    @RequestMapping("/hotels/searchHotelsByName")
    public ModelAndView searchHotelsByName(){
        return new ModelAndView("hotelMain", "hotels", /*TODO*/hotelService.getAllHotels());
    }
    
    /*@RequestMapping("/hotels/{id}")
    public ModelAndView getHotels(@PathVariable int id){
        List hotels;
        ModelAndView model = new ModelAndView("ShowHotels");
        if (id!=0){
            hotels = hotelService.getAllHotelsForCity(id);
            model.addObject("todayDate", LocalDate.now());
        }else {
            hotels = hotelService.hotelsStatistic();
        }
        model.addObject("cityId",id);
        model.addObject("hotels", hotels);
        model.addObject("tableName","Hotels");
        return model;
    }

    @RequestMapping(value = "/hotels/findFreeHotel", method = RequestMethod.POST)
    public ModelAndView findFreeHotel(@RequestParam String From,@RequestParam String To,@RequestParam int cityId){
        LocalDate dateFrom = LocalDate.parse(From);
        LocalDate dateTo = LocalDate.parse(To);


        if (dateFrom.toEpochDay()>dateTo.toEpochDay()){
            return getHotels(cityId);
        }
        List hotels;
        ModelAndView model = new ModelAndView("ShowHotels");
        hotels = hotelService.findFreeHotelInDateRange(cityId,dateFrom,dateTo);
        model.addObject("cityId",cityId);
        model.addObject("todayDate", LocalDate.now());
        model.addObject("hotels", hotels);
        model.addObject("tableName","Hotels");
        return model;
    }*/
}
