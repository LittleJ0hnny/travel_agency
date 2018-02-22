package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.ClientDAO;
import com.lv297.travel_agency.entities.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientHibernateDAOImpl extends ElementDAO<Client, Integer> implements ClientDAO {

    public ClientHibernateDAOImpl() {
        super(Client.class);
    }

}
