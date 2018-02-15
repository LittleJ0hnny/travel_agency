package com.lv297.travel_agency.database.hibernate.daoImpls;

import com.lv297.travel_agency.database.dao.CountryDAO;
import com.lv297.travel_agency.database.entities.Country;
import com.lv297.travel_agency.database.hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {
    public List<Country> getAll() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        List<Country> list;
        EntityManager manager = hibernateUtil.getManager();
        Query query = manager.createQuery("from Country");
        list = query.getResultList();
        return list;
    }
}
