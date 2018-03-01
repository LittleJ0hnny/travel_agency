package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "visa")
public class Visa {
    private int id;
    private Client client;
    private Country country;
    private LocalDate validFrom;
    private LocalDate validTo;
    private LocalDate lastTimeUsed;

    public Visa() {
    }

    public Visa(int id, Client client, Country country, LocalDate validFrom, LocalDate validTo) {
        this.id = id;
        this.client = client;
        this.country = country;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "visa_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name = "valid_from", nullable = false)
    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    @Column(name = "valid_to", nullable = false)
    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    @Column(name = "last_time_used", nullable = false)
    public LocalDate getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(LocalDate lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "id=" + id +
                ", client=" + client +
                ", country=" + country +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
