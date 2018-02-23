package com.lv297.travel_agency.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 22.02.18.
 */

@Controller
public class MainController {

    @RequestMapping("/aaa")
    public String onIndex(){
        return "index";
    }
}
