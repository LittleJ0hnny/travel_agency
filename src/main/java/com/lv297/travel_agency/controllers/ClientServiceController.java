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
public class ClientServiceController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/clients")
    public ModelAndView getClients(){
        List clients = clientService.getAllClients();
        ModelAndView model = new ModelAndView("ShowClients");
        model.addObject("clients", clients);
        model.addObject("tableName","Clients");
        return model;
    }



}
