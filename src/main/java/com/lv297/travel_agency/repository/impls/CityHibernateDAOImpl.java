package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.CityDAO;
import com.lv297.travel_agency.entities.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CityHibernateDAOImpl extends ElementDAO<City, Integer> implements CityDAO {

    public CityHibernateDAOImpl() {
        super(City.class);
    }

}
