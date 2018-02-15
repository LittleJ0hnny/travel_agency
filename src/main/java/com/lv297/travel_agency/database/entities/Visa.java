package com.lv297.travel_agency.database.entities;

import java.util.Date;

public class Visa {
    private int id;
    private Date lastUse;
    private Date validFrom;
    private Date validTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLastUse() {
        return lastUse;
    }

    public void setLastUse(Date lastUse) {
        this.lastUse = lastUse;
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
                ", lastUse=" + lastUse +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
