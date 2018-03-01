package com.lv297.travel_agency.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate bithday;
    private String citizenship;
    private String email;
    private String password;
    private String role;
    private List<Visa> visas;

    public Client(){}

    public Client(String firstname, String lastname, LocalDate bithday, String citizenship, String email, String password, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bithday = bithday;
        this.citizenship = citizenship;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "date_birthday", nullable = false)
    public LocalDate getBithday() {
        return bithday;
    }

    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }

    @Column(name = "citythenship", nullable = false, length = 80)
    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Column(name = "email", nullable = false, unique = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false, length = 10)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Visa> getVisas() {
        return visas;
    }

    public void setVisas(List<Visa> visas) {
        this.visas = visas;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bithday=" + bithday +
                ", citizenship='" + citizenship + '\'' +
                '}';
    }
}
