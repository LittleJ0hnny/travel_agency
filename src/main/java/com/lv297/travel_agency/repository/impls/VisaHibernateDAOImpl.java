package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.VisaDAO;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VisaHibernateDAOImpl extends ElementDAO<Visa, Integer> implements VisaDAO {

    public VisaHibernateDAOImpl() {
        super(Visa.class);
    }


}
