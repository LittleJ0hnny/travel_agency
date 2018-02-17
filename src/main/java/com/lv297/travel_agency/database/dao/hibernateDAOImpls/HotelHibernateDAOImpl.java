package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.HotelDAO;
import com.lv297.travel_agency.entities.Hotel;

public class HotelHibernateDAOImpl extends ElementDAO<Hotel, Integer> implements HotelDAO {

    HotelHibernateDAOImpl() {
        super(Hotel.class);
    }
}
