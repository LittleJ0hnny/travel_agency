package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.RoomDAO;
import com.lv297.travel_agency.entities.Room;

public class RoomHibernateDAOImpl extends ElementDAO<Room, Integer> implements RoomDAO {

    RoomHibernateDAOImpl() {
        super(Room.class);
    }
}
