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
}
