package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.service.BookingService;
import com.lv297.travel_agency.service.ClientService;
import com.lv297.travel_agency.service.HotelService;
import com.lv297.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class BookingServiceController {
    @Autowired
    BookingService bookingService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/booking")
    public ModelAndView cityMain(HttpRequest request) {
        ModelAndView model = new ModelAndView("roomMain");
        Client client = clientService
        Hotel hotel =
        Room room
        bookingService.saveBooking();
        return model;
    }
}
