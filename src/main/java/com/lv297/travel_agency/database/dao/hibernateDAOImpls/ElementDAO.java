package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class ElementDAO<E, PK extends Serializable> implements GenericDAO<E, PK>{

    private final Class<E> elementClass;

    ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public void update(E entity) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.refresh(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public void save(E entity) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()) {
               entityManager.close();
            }
        }
    }

    public void delete(E entity) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }

    public E find(PK id) {
        EntityManager entityManager = null;
        E entity = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entity = entityManager.find(elementClass, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return entity;
    }

    public List<E> findAll() {
        EntityManager entityManager = null;
        List<E> list = null;
        try {
            entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            System.out.println(elementClass.getSimpleName());
            Query query = entityManager.createQuery("from " + elementClass.getSimpleName());
            list = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return list;
    }
}
