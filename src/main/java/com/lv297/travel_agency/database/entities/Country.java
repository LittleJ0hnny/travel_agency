package com.lv297.travel_agency.database.entities;

import java.util.List;

public class Country {
    private int id;
    private String name;
    private List<Visa> visas;
    private List<City> cities;

    public Country() {}

    public Country(int id, String name, List<Visa> visas, List<City> cities) {
        this.id = id;
        this.name = name;
        this.visas = visas;
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Visa> getVisas() {
        return visas;
    }

    public void setVisas(List<Visa> visas) {
        this.visas = visas;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
