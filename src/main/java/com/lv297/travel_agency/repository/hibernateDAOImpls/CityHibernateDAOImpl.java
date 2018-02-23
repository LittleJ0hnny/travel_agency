package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.CityDAO;
import com.lv297.travel_agency.entities.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityHibernateDAOImpl extends ElementDAO<City, Integer> implements CityDAO {

    CityHibernateDAOImpl() {
        super(City.class);
    }

}
