package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.CountryDAO;
import com.lv297.travel_agency.entities.Country;

public class CountryHibernateDAOImpl extends ElementDAO<Country, Integer> implements CountryDAO {

    CountryHibernateDAOImpl() {
        super(Country.class);
    }

}
