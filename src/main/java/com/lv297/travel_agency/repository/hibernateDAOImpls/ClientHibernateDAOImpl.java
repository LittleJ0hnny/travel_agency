package com.lv297.travel_agency.repository.hibernateDAOImpls;

import com.lv297.travel_agency.database.dao.daoAPI.ClientDAO;
import com.lv297.travel_agency.entities.Client;
import com.lv297.travel_agency.entities.Country;
import com.lv297.travel_agency.entities.Visa;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ClientHibernateDAOImpl extends ElementDAO<Client, Integer> implements ClientDAO {

    ClientHibernateDAOImpl() {
        super(Client.class);
    }

    @Override
    public int numberVisas(String firstname, String lastname) {
        int number;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT COUNT(visa) FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        number = (int) (long)query.getSingleResult();
        return number;
    }

    @Override
    public int numberActiveVisas(String firstname, String lastname) {
        int number;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT COUNT(visa) FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname AND " +
                "visa.validTo>DATE(:curentDate)");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        query.setParameter("curentDate", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
        number = (int) (long)query.getSingleResult();
        return number;
    }

    @Override
    public List<Visa> visasForClient(String firstname, String lastname) {
        List visas;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT visa FROM Visa visa " +
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
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT visa FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname AND " +
                "visa.validTo>DATE(:curentDate)");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        query.setParameter("curentDate", LocalDate.now().toString());
        visas = query.getResultList();
        return visas;
    }

    @Override
    public List<Country> visitedCountries(String firstname, String lastname) {
        List visitedCountries;
        Query query = entityManagerFactory.createEntityManager().createQuery("SELECT country FROM Visa visa " +
                "WHERE visa.client.firstname=:firstname AND " +
                "visa.client.lastname=:lastname AND " +
                "visa.lastTimeUsed!=DATE(0000-00-00)");
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        visitedCountries = query.getResultList();
        return visitedCountries;
    }
}
