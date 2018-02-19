package com.lv297.travel_agency.database.dao.hibernateDAOImpls;

import com.lv297.travel_agency.database.HibernateUtil;
import com.lv297.travel_agency.database.dao.daoAPI.ClientDAO;
import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ClientHibernateDAOImpl extends ElementDAO<Client, Integer> implements ClientDAO {

    ClientHibernateDAOImpl() {
        super(Client.class);
    }

    @Override
    public int numberVisas(String firstname, String lastname) {
        return visasForClient(firstname,lastname).size();
    }

    @Override
    public int numberActiveVisas(String firstname, String lastname) {
        return activeVisasForClient(firstname,lastname).size();
    }

    @Override
    public List<Visa> visasForClient(String firstname, String lastname) {
        List visas;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        visas = query.getResultList();
        return visas;
    }

    @Override
    public List<Visa> activeVisasForClient(String firstname, String lastname) {
        List visas;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname AND " +
                "visa.validTo>DATE(:curentDate)");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        query.setParameter("curentDate", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        visas = query.getResultList();
        return visas;
    }

    @Override
    public List<Country> visitedCountries(String firstname, String lastname) {
        List visitedCountries;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Query query = entityManager.createQuery("SELECT country FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname AND " +
                "visa.lastTimeUsed!=DATE(0000-00-00)");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        visitedCountries = query.getResultList();
        return visitedCountries;
    }
}
