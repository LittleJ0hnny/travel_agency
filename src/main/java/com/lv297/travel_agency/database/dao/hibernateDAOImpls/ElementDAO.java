package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ElementDAO<E, PK extends Serializable> implements GenericDAO<E, PK>{

    private final Class<E> elementClass;
    protected final EntityManager entityManager = HibernateUtil.getEntityManager();

    ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public void update(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void save(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public E find(PK id) {
        E entity = null;
        entity = entityManager.find(elementClass, id);
        return entity;
    }

    public List<E> findAll() {
        List<E> list = null;
        System.out.println(elementClass.getSimpleName());
        Query query = entityManager.createQuery("from " + elementClass.getSimpleName());
        list = query.getResultList();
        return list;
    }
}
