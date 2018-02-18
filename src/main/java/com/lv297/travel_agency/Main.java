package com.lv297.travel_agency;

import com.lv297.travel_agency.database.dao.daoAPI.CountryDAO;
import com.lv297.travel_agency.database.dao.hibernateDAOImpls.DAOFactory;
import com.lv297.travel_agency.entities.*;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        DAOFactory daoFactory = DAOFactory.getInstance();

        CountryDAO countryDAO = daoFactory.getCountryHibernateDAO();

        Country country = countryDAO.find(1);
        country.setName("Hohlandia");

        countryDAO.update(country);

        List<Country> list = countryDAO.findAll();

        for(Country country1: list) {
            System.out.println(country1);
        }
    }
}
