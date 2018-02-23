package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public class ElementDAO<E, PK extends Serializable> implements GenericDAO<E, PK> {

    private final Class<E> elementClass;

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Transactional
    public void update(E entity) {
//        entityManager.getTransaction().begin();
        entityManagerFactory.createEntityManager().merge(entity);
//        entityManager.getTransaction().commit();
    }

    @Transactional
    public void save(E entity) {
//        entityManager.getTransaction().begin();
        entityManagerFactory.createEntityManager().persist(entity);
//        entityManager.getTransaction().commit();
    }

    @Transactional
    public void delete(E entity) {
//        entityManager.getTransaction().begin();
        entityManagerFactory.createEntityManager().remove(entity);
//        entityManager.getTransaction().commit();
    }

    public E find(PK id) {
        E entity = null;
        entity = entityManagerFactory.createEntityManager().find(elementClass, id);
        return entity;
    }

    public List<E> findAll() {
        List<E> list = null;
        System.out.println(elementClass.getSimpleName());
        Query query = entityManagerFactory.createEntityManager().createQuery("from " + elementClass.getSimpleName());
        list = query.getResultList();
        return list;
    }
}
