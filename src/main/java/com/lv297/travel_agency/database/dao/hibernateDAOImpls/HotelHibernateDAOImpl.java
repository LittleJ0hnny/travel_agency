package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.HotelDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HotelHibernateDAOImpl extends ElementDAO<Hotel, Integer> implements HotelDAO {

    HotelHibernateDAOImpl() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> findHotelsByCityName(String cityName) {
        City city;
        EntityManager manager = HibernateUtil.getEntityManager();
        Query query = manager.createQuery("SELECT city FROM City city WHERE city.name=:name");
        query.setParameter("name", cityName);
        city = (City) query.getSingleResult();
        if (city == null) {
            return null;
        } else {
            return city.getHotels();
        }
    }
}
