package com.lv297.travel_agency;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.database.hibernate.HibernateUtil;
import com.lv297.travel_agency.database.hibernate.daoImpls.CountryDaoImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        CountryDAO countryDAO = new CountryDaoImpl();
        System.out.println(countryDAO.getAll());
    }
}
