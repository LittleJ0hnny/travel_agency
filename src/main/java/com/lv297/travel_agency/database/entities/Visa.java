package com.lv297.travel_agency.database.entities;

import java.util.Date;

public class Visa {
    private int id;
    private int clientId;
    private int countryId;
    private Date validFrom;
    private Date validTo;

    public Visa() {}

    public Visa(int id, int clientId, int countryId, Date validFrom, Date validTo) {
        this.id = id;
        this.clientId = clientId;
        this.countryId = countryId;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "id=" + id +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
