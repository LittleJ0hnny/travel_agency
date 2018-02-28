//package com.lv297.travel_agency.repository.impls;
//
//import com.lv297.travel_agency.entities.Client;
//import com.lv297.travel_agency.entities.Country;
//import com.lv297.travel_agency.entities.Visa;
//import com.lv297.travel_agency.repository.VisaRepository;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Repository
//@Transactional(readOnly = true)
//public class VisaRepositoryImpl extends SimpleJpaRepository<Visa, Integer> implements VisaRepository {
//
//    private final EntityManager entityManager;
//
//    public VisaRepositoryImpl(EntityManager entityManager) {
//        super(Visa.class, entityManager);
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public int numberVisas(Client client) {
//        int number;
//        Query query = entityManager.createQuery("SELECT COUNT(visa) FROM Visa visa WHERE visa.client.id=:id");
//        query.setParameter("id", client.getId());
//        number = (int) (long) query.getSingleResult();
//        return number;
//    }
//
//    @Override
//    public int numberActiveVisas(Client client) {
//        int number;
//        Query query = entityManager.createQuery("SELECT COUNT(visa) FROM Visa visa " +
//                "WHERE visa.client.id=:id AND visa.validTo > DATE (:curentDate)");
//        query.setParameter("id", client.getId());
//        query.setParameter("curentDate", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
//        number = (int) (long)query.getSingleResult();
//        return number;
//    }
//
//    @Override
//    public List<Visa> getAllVisasForCountry(int countryId) {
//        List visas;
//        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
//                "WHERE visa.country.id=:id");
//        query.setParameter("id", countryId);
//        visas = query.getResultList();
//        return visas;
//    }
//
//    @Override
//    public List<Visa> visasForClient(int clientId) {
//        List visas;
//        Query query = entityManager.createQuery("SELECT visa FROM Visa visa WHERE visa.client.id=:id");
//        query.setParameter("id", clientId);
//        visas = query.getResultList();
//        return visas;
//    }
//
//    @Override
//    public List<Visa> activeVisasForClient(int clientId) {
//        List visas;
//        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
//                "WHERE visa.client.id=:id AND visa.validTo > DATE (:curentDate)");
//        query.setParameter("id", clientId);
//        query.setParameter("curentDate", LocalDate.now().toString());
//        visas = query.getResultList();
//        return visas;
//    }
//
//    @Override
//    public List<Country> visitedCountries(int clientId) {
//        List visitedCountries;
//        Query query = entityManager.createQuery("SELECT visa FROM Visa visa " +
//                "WHERE visa.client.id=:id AND visa.lastTimeUsed != DATE(0000-00-00)");
//        query.setParameter("id", clientId);
//        visitedCountries = query.getResultList();
//        return visitedCountries;
//    }
//}
