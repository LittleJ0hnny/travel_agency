package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    private int id;
    private String name;
    private List<Visa> visas;
    private List<City> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, List<Visa> visas, List<City> cities) {
        this.name = name;
        this.visas = visas;
        this.cities = cities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", unique = true, nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Visa> getVisas() {
        return visas;
    }

    public void setVisas(List<Visa> visas) {
        this.visas = visas;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
