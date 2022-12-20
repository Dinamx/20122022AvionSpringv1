package com.mix.avion.model;

import javax.persistence.*;

@Entity
@Table(name = "avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idsociete")
    private Integer idsociete;

    @Column(name = "immatriculation", length = 30)
    private String immatriculation;

    @Column(name = "marque", length = 30)
    private String marque;

    @Column(name = "modele", length = 30)
    private String modele;

    @Column(name = "kilometrageentree")
    private Integer kilometrageentree;

//    @Lob
    @Column(name = "imageavion")
    private String imageavion;

    public String getImageavion() {
        return imageavion;
    }

    public void setImageavion(String imageavion) {
        this.imageavion = imageavion;
    }

    public Integer getKilometrageentree() {
        return kilometrageentree;
    }

    public void setKilometrageentree(Integer kilometrageentree) {
        this.kilometrageentree = kilometrageentree;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Integer getIdsociete() {
        return idsociete;
    }

    public void setIdsociete(Integer idsociete) {
        this.idsociete = idsociete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}