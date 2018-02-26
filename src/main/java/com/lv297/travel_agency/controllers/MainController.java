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
    public ModelAndView findFreeHotel(@RequestParam String From, String To, int cityId){
        LocalDate dateFrom = LocalDate.parse(From);
        LocalDate dateTo = LocalDate.parse(To);


        if (dateFrom.toEpochDay()>dateTo.toEpochDay()){
            return getHotels(cityId);
        }
        List hotels;
        ModelAndView model = new ModelAndView("ShowHotels");
        if (dateFrom.equals(dateTo)){
            hotels = hotelService.findFreeHotelInDate(cityId,dateFrom);
        }else{
            hotels = hotelService.findFreeHotelInDateRange(cityId,dateFrom,dateTo);
        }
        model.addObject("cityId",cityId);
        model.addObject("todayDate", LocalDate.now());
        model.addObject("hotels", hotels);
        model.addObject("tableName","Hotels");
        return model;
    }

    @RequestMapping("/rooms/{id}")
    public ModelAndView getHotelsRooms(@PathVariable int id){
        List rooms;
        ModelAndView model = new ModelAndView("ShowRooms");
        if (id!=0){
            rooms = roomService.getAllRoomsForHotel(id);
        }else {
            rooms = roomService.getAllRooms();
        }
        model.addObject("hotelId",id);
        model.addObject("todayDate", LocalDate.now());
        model.addObject("rooms", rooms);
        model.addObject("tableName","Rooms");
        return model;
    }

    @RequestMapping(value = "/rooms/findFreeroom", method = RequestMethod.POST)
    public ModelAndView findFreeRoomInHotel(@RequestParam String From, String To, int hotelId){
        LocalDate dateFrom = LocalDate.parse(From);
        LocalDate dateTo = LocalDate.parse(To);


        if (dateFrom.toEpochDay()>dateTo.toEpochDay()){
            return getHotelsRooms(hotelId);
        }
        List rooms;
        ModelAndView model = new ModelAndView("ShowRooms");
        if (dateFrom.equals(dateTo)){
            rooms = roomService.findFreeRoomInHotelInDate(hotelId,dateFrom);
        }else{
            rooms = roomService.findFreeRoomInHotelInDateRange(hotelId,dateFrom,dateTo);
        }
        model.addObject("hotelId",hotelId);
        model.addObject("todayDate", LocalDate.now());
        model.addObject("hotels", rooms);
        model.addObject("tableName","Rooms");
        return model;
    }

    @RequestMapping("/clients")
    public ModelAndView getClients(){
        List clients = clientService.getAllClients();
        ModelAndView model = new ModelAndView("ShowClients");
        model.addObject("clients", clients);
        model.addObject("tableName","Clients");
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
