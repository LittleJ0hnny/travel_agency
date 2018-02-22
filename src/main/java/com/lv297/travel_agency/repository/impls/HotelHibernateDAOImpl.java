package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.HotelDAO;
import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HotelHibernateDAOImpl extends ElementDAO<Hotel, Integer> implements HotelDAO {

    public HotelHibernateDAOImpl() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> findHotelsByCityName(String cityName) {
        City city;
        Query query = super.entityManager.createQuery("SELECT city FROM City city WHERE city.name=:name");
        query.setParameter("name", cityName);
        city = (City) query.getSingleResult();
        if (city == null) {
            return null;
        } else {
            return city.getHotels();
        }
    }
}
