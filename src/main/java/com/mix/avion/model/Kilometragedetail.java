package com.mix.avion.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "kilometragedetail")
public class Kilometragedetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "idavion")
    private Integer idavion;

    @Column(name = "immatriculation", length = 30)
    private String immatriculation;

    @Column(name = "marque", length = 30)
    private String marque;

    @Column(name = "modele", length = 30)
    private String modele;

    @Column(name = "debutkm")
    private Integer debutkm;

    @Column(name = "finkm")
    private Integer finkm;

    @Column(name = "dateactuel")
    private LocalDate dateactuel;

    public LocalDate getDateactuel() {
        return dateactuel;
    }

    public Integer getFinkm() {
        return finkm;
    }

    public Integer getDebutkm() {
        return debutkm;
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

    public Integer getIdavion() {
        return idavion;
    }

    public Integer getId() {
        return id;
    }

    protected Kilometragedetail() {
    }
}