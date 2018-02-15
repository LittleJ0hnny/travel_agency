package com.lv297.travel_agency;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.database.entities.City;
import com.lv297.travel_agency.database.entities.Country;
import com.lv297.travel_agency.database.hibernate.daoImpls.CountryDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        CountryDAO countryDAO = new CountryDaoImpl();
        List<Country> list = countryDAO.getAll();
        for(Country country: list) {
            System.out.println(country);
            for(City city : country.getCities()) {
                System.out.println(city);
            }
        }
    }
}
