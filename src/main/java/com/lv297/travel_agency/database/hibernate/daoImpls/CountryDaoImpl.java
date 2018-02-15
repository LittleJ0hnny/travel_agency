package com.lv297.travel_agency.database.hibernate.daoImpls;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.database.entities.Country;
import com.lv297.travel_agency.database.hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {
    public List<Country> getAll() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        List<Country> list = new ArrayList<>();
        EntityManager manager = hibernateUtil.getManager();
        Country country = manager.find(Country.class, 1);
        list.add(country);
        return list;
    }
}
