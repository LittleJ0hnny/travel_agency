package com.lv297.travel_agency.repository.impls;

import com.lv297.travel_agency.repository.api.GenericDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class ElementDAO<E, PK extends Serializable> implements GenericDAO<E, PK>{

    private final Class<E> elementClass;

    ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public E update(E entity) {
        return null;
    }

    public void save(E entity) {
    }

    @Transactional
    public void delete(E entity) {

    }

    public E find(PK id) {
        return null;
    }

    public List<E> findAll() {
        return null;
    }
}
