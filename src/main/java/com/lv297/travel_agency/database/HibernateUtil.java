package com.lv297.travel_agency.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager em;

    private static void buildEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    }

    public static EntityManager getEntityManager() {
        if(entityManagerFactory == null) {
            buildEntityManagerFactory();
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
}
