package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.util.List;

@Cacheable
@Entity
@Table(name = "hotel")
public class Hotel {
    private int id;
    private String name;
    private City city;
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(int id, String name, City city, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
