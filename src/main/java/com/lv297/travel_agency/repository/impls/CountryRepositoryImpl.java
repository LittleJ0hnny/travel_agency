package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import com.lv297.travel_agency.repository.CountryRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class CountryRepositoryImpl extends SimpleJpaRepository<Country, Integer> implements CountryRepository {

    private final EntityManager entityManager;

    public CountryRepositoryImpl(EntityManager entityManager) {
        super(Country.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Country merge(Country country) {
        return entityManager.merge(country);
    }
}
