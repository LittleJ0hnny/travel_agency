package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.Visa;
import com.lv297.travel_agency.repository.api.CountryDAO;
import com.lv297.travel_agency.entities.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryHibernateDAOImpl implements CountryDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Country update(Country entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void save(Country entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Country entity) {
        entityManager.remove(entity);
    }

    @Override
    public Country find(Integer id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    public List<Country> findAll() {
        List<Country> list = null;
        Query query = entityManager.createQuery("from " + Country.class.getSimpleName());
        list = query.getResultList();
        return list;
    }

    @Override
    public int numberVisas(String name) {
        return 0;
    }

    @Override
    public List<Visa> visasForCountry(String name) {
        return null;
    }
}
