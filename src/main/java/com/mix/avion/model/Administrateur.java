package com.mix.avion.model;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 10)
    private String email;

    @Column(name = "psswd", length = 10)
    private String psswd;

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}