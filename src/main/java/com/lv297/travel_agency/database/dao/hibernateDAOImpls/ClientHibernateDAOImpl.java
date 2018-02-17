package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.ClientDAO;
import com.lv297.travel_agency.entities.Client;

public class ClientHibernateDAOImpl extends ElementDAO<Client, Integer> implements ClientDAO {

    ClientHibernateDAOImpl() {
        super(Client.class);
    }

}
