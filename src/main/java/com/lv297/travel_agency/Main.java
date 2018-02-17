package com.lv297.travel_agency;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;
import com.lv297.travel_agency.database.hibernate.daoImpls.CountryDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        CountryDAO countryDAO = new CountryDaoImpl();
        List<Country> list = countryDAO.getAll();
        System.out.println("Print countries:");
        for(Country country : list) {
            System.out.println(country);
            for(City city : country.getCities()) {
                System.out.println("    "+city);
                for(Hotel hotel:city.getHotels()){
                    System.out.println("        "+hotel);
                    for(Room room:hotel.getRooms()){
                        System.out.println("            "+room);
                    }
                    System.out.println();
                }
            }
        }
    }
}
