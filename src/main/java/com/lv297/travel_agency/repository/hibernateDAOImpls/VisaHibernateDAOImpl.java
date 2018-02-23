package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.VisaDAO;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.stereotype.Repository;


@Repository
public class VisaHibernateDAOImpl extends ElementDAO<Visa, Integer> implements VisaDAO {

    VisaHibernateDAOImpl() {
        super(Visa.class);
    }
}
