package com.lv297.travel_agency;

import com.lv297.travel_agency.database.dao.hibernateDAOImpls.DAOFactory;
import com.lv297.travel_agency.database.dao.hibernateDAOImpls.HotelHibernateDAOImpl;
import com.lv297.travel_agency.database.dao.hibernateDAOImpls.RoomHibernateDAOImpl;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.entities.Room;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        DAOFactory daoFactory = DAOFactory.getInstance();

        RoomHibernateDAOImpl roomHibernateDAO = daoFactory.getRoomHibernateDAO();

        List<Room> list = roomHibernateDAO.findFreeRoomInHotelInDateRange("Leopolis","2018-03-10","2018-03-29");
        for (Room room : list) {
            System.out.println(room);
        }

    }
}
