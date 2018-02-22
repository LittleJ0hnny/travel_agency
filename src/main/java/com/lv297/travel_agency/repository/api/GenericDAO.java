package com.lv297.travel_agency.repository.api;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface GenericDAO<E, PK extends Serializable> extends Repository {
    E update(E entity);
    void save(E entity);
    void delete(E entity);
    E find(PK id);
    List<E> findAll();
}
