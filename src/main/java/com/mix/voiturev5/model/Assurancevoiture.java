package com.mix.voiturev5.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "assurancevoiture")
public class Assurancevoiture {
    @Id
    @Column(name = "idassurance")
    private Integer idassurance;

    @Column(name = "idvoiture")
    private Integer idvoiture;

    @Column(name = "idsociete")
    private Integer idsociete;

    @Column(name = "immatriculation", length = 30)
    private String immatriculation;

    @Column(name = "marque", length = 30)
    private String marque;

    @Column(name = "modele", length = 30)
    private String modele;

    @Column(name = "date_fin_validite")
    private Timestamp dateFinValidite;

    @Column(name = "nomsociete", length = 20)
    private String nomsociete;

    public String getNomsociete() {
        return nomsociete;
    }

    public Timestamp getDateFinValidite() {
        return dateFinValidite;
    }

    public String getModele() {
        return modele;
    }

    public String getMarque() {
        return marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public Integer getIdsociete() {
        return idsociete;
    }

    public Integer getIdvoiture() {
        return idvoiture;
    }

    public Integer getIdassurance() {
        return idassurance;
    }

    protected Assurancevoiture() {
    }
}