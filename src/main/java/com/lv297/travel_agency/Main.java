package com.lv297.travel_agency;

import com.lv297.travel_agency.configuration.PersistenceContext;
import com.lv297.travel_agency.entities.*;
import com.lv297.travel_agency.service.*;
import com.lv297.travel_agency.service.impls.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
        VisaService service1 = context.getBean(VisaServiceImpl.class);
        CityService service2 = context.getBean(CityServiceImpl.class);
        HotelService service3 = context.getBean(HotelServiceImpl.class);
        ClientService service4 = context.getBean(ClientServiceImpl.class);

        Client client = service4.getClientById(1);
        List<Country>  list = service1.visitedCountries(client);
        for(Country country: list){
            System.out.println(country);
        }

        /*for(Room room: list) {
            System.out.println(room);
        }*/

        /*for(Country country: list) {
            System.out.println(country);
            for (City city: country.getCities()) {
                System.out.println(city);
                for(Hotel hotel: city.getHotels()) {
                    System.out.println(hotel);
                    for(Room room: hotel.getRooms()) {
                        System.out.println(room);
                    }
                }
            }
        }*/
    }
}
