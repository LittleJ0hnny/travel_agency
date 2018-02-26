package com.lv297.travel_agency;

import com.lv297.travel_agency.configuration.PersistenceContext;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.service.CountryService;
import com.lv297.travel_agency.service.impls.CountryServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
        CountryService countryDao = context.getBean(CountryServiceImpl.class);

        List<Country> list = countryDao.getAllCountries();

        for(Country country: list) {
            System.out.println(country);
        }
    }
}
