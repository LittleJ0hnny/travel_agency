package com.lv297.travel_agency;

import com.lv297.travel_agency.configuration.PersistenceContext;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.repository.api.CountryDAO;
import com.lv297.travel_agency.repository.impls.CountryHibernateDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
<<<<<<< HEAD
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
        CountryDAO countryDao = context.getBean(CountryHibernateDAOImpl.class);

        countryDao.delete(countryDao.find(1));

        List<Country> list = countryDao.findAll();
=======
        DAOFactory daoFactory = DAOFactory.getInstance();

        CountryDAO countryDAO = daoFactory.getCountryHibernateDAO();

        List<Country> list = countryDAO.findAll();
>>>>>>> 6c40e35ce762d05fce45d89cd0c021e93f740e33

        for(Country country: list) {
            System.out.println(country);
        }
    }
}
