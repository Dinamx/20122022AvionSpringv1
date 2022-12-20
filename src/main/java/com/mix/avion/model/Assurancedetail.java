package com.mix.avion.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "assurancedetail")
public class Assurancedetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "modele", length = 30)
    private String modele;

    @Column(name = "marque", length = 30)
    private String marque;

    @Column(name = "immatriculation", length = 30)
    private String immatriculation;

    @Column(name = "date_debut_validite")
    private Timestamp dateDebutValidite;

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

    public Timestamp getDateDebutValidite() {
        return dateDebutValidite;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Integer getId() {
        return id;
    }

    protected Assurancedetail() {
    }
}