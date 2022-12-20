package com.mix.voiturev5.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idvoiture")
    private Integer idvoiture;

    @Column(name = "dateactuel", nullable = false)
    private LocalDate dateactuel;

    @Column(name = "debutkm")
    private Integer debutkm;

    @Column(name = "finkm")
    private Integer finkm;

    public Integer getFinkm() {
        return finkm;
    }

    public void setFinkm(Integer finkm) {
        this.finkm = finkm;
    }

    public Integer getDebutkm() {
        return debutkm;
    }

    public void setDebutkm(Integer debutkm) {
        this.debutkm = debutkm;
    }

    public LocalDate getDateactuel() {
        return dateactuel;
    }

    public void setDateactuel(LocalDate dateactuel) {
        this.dateactuel = dateactuel;
    }

    public Integer getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(Integer idvoiture) {
        this.idvoiture = idvoiture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}