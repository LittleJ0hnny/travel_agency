package com.lv297.travel_agency.database.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    private  EntityManager entityManager = entityManagerFactory.createEntityManager();

    public EntityManager getManager() {
       return entityManager;
    }
}
