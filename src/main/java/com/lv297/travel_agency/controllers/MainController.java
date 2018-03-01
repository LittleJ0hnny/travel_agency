package com.lv297.travel_agency.controllers;

import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;


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
    public ModelAndView onIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public ModelAndView onLogin() {
        return new ModelAndView("loginPage");
    }
    @RequestMapping("/logout")
    public ModelAndView onLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("index");
    }

    @RequestMapping("/loginProcess")
    public ModelAndView loginProcess(HttpServletRequest request) {
        String email = request.getParameter("email");
        Client client = clientService.getClientByEmail(email);
        if (!clientService.validateEmail(email)) {
            return new ModelAndView("loginPage", "emailMessage", "Email is incorrect. Try again.");
        } else if (!client.getPassword().equals(request.getParameter("password"))) {
            return new ModelAndView("loginPage", "passwordMessage", "Password is incorrect. Try again.");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", client);
            session.setMaxInactiveInterval(60);
            return new ModelAndView("index");
        }
    }

    @RequestMapping("/registration")
    public ModelAndView onRegistration() {
        return new ModelAndView("registrationPage", "countries", countryService.getAllCountries());
    }

    @RequestMapping("/registrationProcess")
    public ModelAndView registrationProcess(HttpServletRequest request){
        ModelAndView model = new ModelAndView("registrationPage");
        model.addObject("countries", countryService.getAllCountries());
        if (clientService.validateEmail(request.getParameter("email"))) {
            model.addObject("emailMessage", "This email alredy exists. Please input another.");
            return model;
        } else if(clientService.validatePassword(request.getParameter("password"), request.getParameter("password2"))) {
            model.addObject("passwordMessage", "Passwords doesn`t match try again.");
            return model;
        } else {
            clientService.saveClient(new Client(
                    request.getParameter("firstname"),
                    request.getParameter("lastname"),
                    LocalDate.parse(request.getParameter("birthday")),
                    request.getParameter("citizenship"),
                    request.getParameter("email"),
                    request.getParameter("password"),
                    "user"
                    ));
            return new ModelAndView("index");
        }
    }
}
