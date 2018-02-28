package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.City;
import com.lv297.travel_agency.entities.Hotel;
import com.lv297.travel_agency.repository.CityRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CityRepositoryImpl extends SimpleJpaRepository<City, Integer> implements CityRepository {
    private final EntityManager entityManager;

    public CityRepositoryImpl(EntityManager entityManager) {
        super(City.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<City> getAllCitiesForCountry(int countryId) {
        List cities;
        Query query = entityManager.createQuery("SELECT city FROM City city " +
                "WHERE city.country.id=:id");
        query.setParameter("id", countryId);
        cities = query.getResultList();
        return cities;
    }

    @Override
    public City merge(City city) {
        return entityManager.merge(city);
    }


}
