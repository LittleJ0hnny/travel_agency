package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.entities.Booking;
import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.service.BookingService;
import com.lv297.travel_agency.service.ClientService;
import com.lv297.travel_agency.service.HotelService;
import com.lv297.travel_agency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
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
    public ModelAndView cityMain(HttpServletRequest request) {
        Client client = clientService.getClientById(Integer.valueOf(request.getParameter("userId")));
        Hotel hotel = hotelService.getHotelById(Integer.valueOf(request.getParameter("hotelId")));
        Room room = roomService.getRoomById(Integer.valueOf(request.getParameter("roomId")));
        LocalDate dateFrom = LocalDate.parse(request.getParameter("dateFrom"));
        LocalDate dateTo = LocalDate.parse(request.getParameter("dateTo"));
        if(clientService.checkClientVisas(client, hotel.getCity().getCountry(), dateTo)) {
            bookingService.saveBooking(new Booking(client, hotel, room, dateFrom, dateTo));
            return new ModelAndView("successPage","message", "You booked the room");
        } else {
            return new ModelAndView("failurePage", "message", "You can`t book this room");
        }
    }
}
