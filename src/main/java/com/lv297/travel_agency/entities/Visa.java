package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.util.Date;

@Cacheable
@Entity
@Table(name = "visa")
public class Visa {
    private int id;
    private Client client;
    private Country country;
    private Date validFrom;
    private Date validTo;
    private Date lastTimeUsed;

    public Visa() {}

    public Visa(int id, Client client, Country country, Date validFrom, Date validTo) {
        this.id = id;
        this.client = client;
        this.country = country;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="visa_id", nullable = false, unique = true)
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
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Column(name = "valid_to", nullable = false)
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Column(name = "last_time_used", nullable = false)
    public Date getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(Date lastTimeUsed) {
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
