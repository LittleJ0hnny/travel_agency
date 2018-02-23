package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.CountryDAO;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryHibernateDAOImpl extends ElementDAO<Country, Integer> implements CountryDAO {

    CountryHibernateDAOImpl() {
        super(Country.class);
    }

    @Override
    public int numberVisas(String name) {
        int number;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT COUNT(visa) FROM Visa visa " +
                "WHERE visa.country.name=:name");
        query.setParameter("name", name);
        number = (int)(long) query.getSingleResult();
        return number;
    }

    @Override
    public List<Visa> visasForCountry(String name) {
        List visas;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT visa FROM Visa visa " +
                "WHERE visa.country.name=:name");
        query.setParameter("name", name);
        visas = query.getResultList();
        return visas;
    }
}
