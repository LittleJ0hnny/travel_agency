package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.service.RoomService;
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
public class RoomServiceController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/rooms/selectRoomsByHotel/{id}")
    public ModelAndView selectRoomsByHotel(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("roomMain");
        modelAndView.addObject("rooms", roomService.getAllRoomsForHotel(id));
        modelAndView.addObject("hotelId", id);
        return modelAndView;
    }

    @RequestMapping("/rooms/searchRoomsByDateRange")
    public ModelAndView searchRoomsByDateRange(@RequestParam int hotelId, @RequestParam String dateFrom, @RequestParam String dateTo) {
        LocalDate from = LocalDate.parse(dateFrom);
        LocalDate to = LocalDate.parse(dateTo);

        if (from.toEpochDay() > to.toEpochDay()) {
            return selectRoomsByHotel(hotelId);
        }
        List rooms;
        ModelAndView model = new ModelAndView("roomsFreeForBooking");
        rooms = roomService.findFreeRoomInHotelInDateRange(hotelId, from, to);
        model.addObject("dateFrom", from.toString());
        model.addObject("dateTo", to.toString());
        model.addObject("hotelId", hotelId);
        model.addObject("rooms", rooms);
        return model;
    }

    @RequestMapping("/rooms/statistic/{hotelId}")
    public ModelAndView getStatistic(@PathVariable int hotelId) {
        ModelAndView modelAndView = new ModelAndView("roomStatistic");
        modelAndView.addObject("hotelId", hotelId);
        return modelAndView;
    }

    @RequestMapping("/rooms/roomStatistic")
    public ModelAndView getRoomsStatistic(@RequestParam int hotelId, @RequestParam String dateFrom, @RequestParam String dateTo) {
        LocalDate from = LocalDate.parse(dateFrom);
        LocalDate to = LocalDate.parse(dateTo);

        System.out.println(from);
        System.out.println(to);
        if (from.toEpochDay() > to.toEpochDay()) {
            return getStatistic(hotelId);
        }


        ModelAndView modelAndView = new ModelAndView("roomStatistic");
        modelAndView.addObject("hotelId", hotelId);
        modelAndView.addObject("rooms",roomService.getRoomsStatistics(hotelId,from,to));
        return modelAndView;
    }






    /*@RequestMapping("/rooms/{id}")
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
    public ModelAndView findFreeRoomInHotel(@RequestParam String From,@RequestParam String To,@RequestParam int hotelId){
        LocalDate dateFrom = LocalDate.parse(From);
        LocalDate dateTo = LocalDate.parse(To);


        if (dateFrom.toEpochDay()>dateTo.toEpochDay()){
            return getHotelsRooms(hotelId);
        }
        List rooms;
        ModelAndView model = new ModelAndView("ShowRooms");
        rooms = roomService.findFreeRoomInHotelInDateRange(hotelId,dateFrom,dateTo);
        model.addObject("hotelId",hotelId);
        model.addObject("todayDate", LocalDate.now());
        model.addObject("rooms", rooms);
        model.addObject("tableName","Rooms");
        return model;
    }*/
}
