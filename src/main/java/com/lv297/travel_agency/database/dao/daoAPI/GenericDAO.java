package com.lv297.travel_agency.database.dao.daoAPI;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, PK extends Serializable> {
    void update(E entity);
    void save(E entity);
    void delete(E entity);
    E find(PK id);
    List<E> findAll();
}
