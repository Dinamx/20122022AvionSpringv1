package com.mix.avion.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idadmin")
    private Administrateur idadmin;

    @Column(name = "token", length = 200)
    private String token;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @Column(name = "dateexpiration")
    private LocalDate dateexpiration;

    public Token() {

    }

    public LocalDate getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(LocalDate dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Administrateur getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Administrateur idadmin) {
        this.idadmin = idadmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Token(Administrateur idadmin, String token, LocalDate datecreation, LocalDate dateexpiration) {
        this.idadmin = idadmin;
        this.token = token;
        this.datecreation = datecreation;
        this.dateexpiration = dateexpiration;
    }
}